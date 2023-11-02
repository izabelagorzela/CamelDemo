package gorzela.izabela.CamelDemo.routeBuilders;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileToFileRouteBuilder extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:sampleDirectory/from").to("file:sampleDirectory/to");
    }
}