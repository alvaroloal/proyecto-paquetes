package com.salesianostriana.dam.proyectoalvarolorentealman.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectoalvarolorentealman.exception.ResourceNotFoundException;
import com.salesianostriana.dam.proyectoalvarolorentealman.model.Address;
import com.salesianostriana.dam.proyectoalvarolorentealman.model.Delivery;
import com.salesianostriana.dam.proyectoalvarolorentealman.model.Invoice;
import com.salesianostriana.dam.proyectoalvarolorentealman.model.Packet;
import com.salesianostriana.dam.proyectoalvarolorentealman.model.PacketStatus;
import com.salesianostriana.dam.proyectoalvarolorentealman.model.User;
import com.salesianostriana.dam.proyectoalvarolorentealman.repository.DeliveryRepository;

import jakarta.transaction.Transactional;



@Service
public class DeliveryService {

    // Inyecta una instancia de DeliveryRepository para acceder a las operaciones CRUD
    @Autowired
    private DeliveryRepository deliveryRepository;

    // Inyecta una instancia de UserService para gestionar usuarios
    @Autowired
    private UserService userService;

    // Inyecta una instancia de AddressService para gestionar direcciones
    @Autowired
    private AddressService addressService;

    // Inyecta una instancia de InvoiceService para gestionar facturas
    @Autowired
    private InvoiceService invoiceService;

    // Verifica si una entrega existe por su ID
    public Boolean existsById(Long id) {
        return this.deliveryRepository.existsById(id);
    }
    
    // Obtiene todas las entregas
    public List<Delivery> getAllDeliveries() {
        return this.deliveryRepository.findAll();
    }

    // Obtiene una entrega por su ID
    public Delivery getDeliveryById(Long id) {
        return this.deliveryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Envío no encontrado con el id: " + id));
    }

    // Obtiene entregas por nombre de usuario
    public List<Delivery> getDeliveriesByUsername(String username) {
        User user = this.userService.getUserByUsername(username);
        Address address = this.addressService.getAddressById(user.getAddress().getId());
        return this.deliveryRepository.findBySourceId(address.getId());
    }
    
    // Crea una nueva entrega
    @Transactional
    public Delivery createDelivery(Delivery delivery) throws ParseException {
        User user = userService.getUserById(delivery.getSource().getId());
        delivery.setSource(addressService.getAddressById(user.getAddress().getId()));
        addressService.createAddress(delivery.getDestination());

        Double packetVolume = delivery.getPacket().getPacketHeight() * delivery.getPacket().getPacketWidth() * delivery.getPacket().getPacketLength();
        Double price = calculatePrice(delivery.getPacket(), packetVolume);
        Integer days = calculateDaysAndStatus(delivery);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = dateFormat.format(new Date());
        Date deliveryDate = dateFormat.parse(formattedDate);

        Calendar cal = Calendar.getInstance();
        cal.setTime(deliveryDate);
        cal.add(Calendar.DATE, days);
        Date estimatedArrivalDate = cal.getTime();

        delivery.setDeliveryDate(deliveryDate);
        delivery.setEstimatedArrivalDate(estimatedArrivalDate);
        delivery.setInvoice(invoiceService.createInvoice(generateInvoice(delivery, price)));

        return deliveryRepository.save(delivery);
    }
    
    // Calcula el precio de la entrega en función del tipo y volumen del paquete
    private Double calculatePrice(Packet packet, Double packetVolume) {
        Double price;
        switch (packet.getPacketType()) {
            case SOBRE:
                price = 2.0;
                break;
            case CAJA:
                price = 5.0 + packetVolume / 1000;
                break;
            case DOCUMENTO:
                price = 1.0;
                break;
            default:
                price = 0.0;
                break;
        }
        if (packet.getPacketWeight() > 1.0) {
            price *= 1.1;
        }
        return price;
    }

    // Calcula los días de entrega y el estado del paquete en función del tipo de transporte
    private Integer calculateDaysAndStatus(Delivery delivery) {
        Integer days;
        switch (delivery.getTransportation()) {
            case URGENTE:
                delivery.setStatus(PacketStatus.EN_TRANSITO);
                days = 1;
                break;
            case EXPRES:
                delivery.setStatus(PacketStatus.PENDIENTE);
                days = 3;
                break;
            default:
                delivery.setStatus(PacketStatus.PENDIENTE);
                days = 7;
                break;
        }
        return days;
    }

    // Genera una factura para la entrega
    private Invoice generateInvoice(Delivery delivery, Double price) {
        Invoice invoice = new Invoice();
        invoice.setServiceInfo("Envío de " + delivery.getPacket().getPacketType() + " a " + delivery.getDestination().getCity() + ", " + delivery.getDestination().getCountry());
        invoice.setPrice(price);
        invoice.setTax(0.1);
        invoice.setTotal(price * (1 + 0.1));
        invoice.setDate(delivery.getDeliveryDate());
        invoice.setDueDate(delivery.getEstimatedArrivalDate());
        invoice.setCustomerInfo(delivery.getSource());
        return invoice;
    }
}