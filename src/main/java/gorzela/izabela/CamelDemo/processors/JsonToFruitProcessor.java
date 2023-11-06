package gorzela.izabela.CamelDemo.processors;

import com.fasterxml.jackson.databind.ObjectMapper;
import gorzela.izabela.CamelDemo.entities.Fruit;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class JsonToFruitProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String fruitJson = exchange.getMessage().getBody(String.class);
        Fruit fruit = mapper.readValue(fruitJson, Fruit.class);
        exchange.getMessage().setBody(fruit, Fruit.class);
    }
}