package gorzela.izabela.CamelDemo.routeBuilders;

import gorzela.izabela.CamelDemo.processors.SampleProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileToFileRouteBuilder extends RouteBuilder {

    @Autowired
    private SampleProcessor sampleProcessor;
    @Override
    public void configure() throws Exception {
        from("file:sampleDirectory/from")
            .process(sampleProcessor)
        .to("file:sampleDirectory/to");
    }
}