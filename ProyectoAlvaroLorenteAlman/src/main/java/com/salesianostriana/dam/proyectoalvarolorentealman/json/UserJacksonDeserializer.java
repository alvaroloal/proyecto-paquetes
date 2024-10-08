package com.salesianostriana.dam.proyectoalvarolorentealman.json;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.salesianostriana.dam.proyectoalvarolorentealman.model.Address;
import com.salesianostriana.dam.proyectoalvarolorentealman.model.Admin;
import com.salesianostriana.dam.proyectoalvarolorentealman.model.Customer;
import com.salesianostriana.dam.proyectoalvarolorentealman.model.User;
import com.salesianostriana.dam.proyectoalvarolorentealman.model.UserRole;

@JsonComponent
public class UserJacksonDeserializer extends JsonDeserializer<User> {
	// Constructor por defecto
    public UserJacksonDeserializer() {
        super();
    }

    // Método principal de deserialización
    @Override
    public User deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode jsonNode = objectCodec.readTree(jsonParser);
        
        JsonNode roleNode = jsonNode.get("role");
        String role = (roleNode != null && !(roleNode instanceof NullNode)) ? roleNode.asText() : null;

        // Deserializa según el rol del usuario
        // En funcion del tipo de rol crea un tipo de usuario u otro
        if (UserRole.ROLE_ADMIN.name().equals(role)) {
            return handleMissingFields(objectCodec.treeToValue(jsonNode, Admin.class));
        } else {
            return handleMissingFields(objectCodec.treeToValue(jsonNode, Customer.class));
        }
    }

    // Maneja campos faltantes estableciendo valores por defecto
    private <T extends User> T handleMissingFields(T user) {
        if (user.getUsername() == null) {
            user.setUsername("");
        }
        
        if (user.getPassword() == null) {
            user.setPassword("");
        }
        
        if (user.getAddress() == null) {
            user.setAddress(new Address());
        }

        if (user.getRole() == null) {
            user.setRole(UserRole.ROLE_CUSTOMER);
        }

        return user;
    }
}
