package gorzela.izabela.CamelDemo.routeBuilders;

import gorzela.izabela.CamelDemo.entities.Fruit;
import gorzela.izabela.CamelDemo.processors.BodyPrintingProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileToFileRouteBuilder extends RouteBuilder {

    @Autowired
    private BodyPrintingProcessor bodyPrintingProcessor;

    @Override
    public void configure() throws Exception {
        from("file:sampleDirectory/from")
            .process(bodyPrintingProcessor)
            .unmarshal()
                .json(JsonLibrary.Jackson, Fruit.class)
            .process(bodyPrintingProcessor)
        .stop();
    }
}