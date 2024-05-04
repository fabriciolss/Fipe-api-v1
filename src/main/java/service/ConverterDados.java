package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.asm.TypeReference;

import java.util.List;

public class ConverterDados implements IConverterDados {
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) throws JsonProcessingException {
        return this.mapper.readValue(json, classe);
    }

    @Override
    public <T> List<T> obterLista(String json, Class<T> classe) throws JsonProcessingException {
        CollectionType lista = mapper.getTypeFactory()
                .constructCollectionType(List.class, classe);

        return mapper.readValue(json, lista);
    }
}
