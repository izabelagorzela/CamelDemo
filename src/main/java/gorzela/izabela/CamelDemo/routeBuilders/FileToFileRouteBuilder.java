package gorzela.izabela.CamelDemo.routeBuilders;

import gorzela.izabela.CamelDemo.processors.FileNameChangingProcessor;
import gorzela.izabela.CamelDemo.processors.SimplePrintingProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileToFileRouteBuilder extends RouteBuilder {

    @Autowired
    private SimplePrintingProcessor simplePrintingProcessor;

    @Autowired
    private FileNameChangingProcessor fileNameChangingProcessor;

    @Override
    public void configure() throws Exception {
        from("file:sampleDirectory/from")
            .process(simplePrintingProcessor)
            .process(fileNameChangingProcessor)
            .process(simplePrintingProcessor)
        .to("file:sampleDirectory/to");
    }
}