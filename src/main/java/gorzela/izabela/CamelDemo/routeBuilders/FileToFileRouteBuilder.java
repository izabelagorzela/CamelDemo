package gorzela.izabela.CamelDemo.routeBuilders;

import gorzela.izabela.CamelDemo.processors.BodyPrintingProcessor;
import gorzela.izabela.CamelDemo.processors.JsonToFruitProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileToFileRouteBuilder extends RouteBuilder {

    @Autowired
    private JsonToFruitProcessor jsonToFruitProcessor;
    @Autowired
    private BodyPrintingProcessor bodyPrintingProcessor;

    @Override
    public void configure() throws Exception {
        from("file:sampleDirectory/from")
            .process(bodyPrintingProcessor)
            .process(jsonToFruitProcessor)
            .process(bodyPrintingProcessor)
        .stop();
    }
}