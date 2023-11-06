package gorzela.izabela.CamelDemo.routeBuilders;

import gorzela.izabela.CamelDemo.processors.ExtentionHeaderPrintingProcessor;
import gorzela.izabela.CamelDemo.processors.ExtentionHeaderSettingProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileToFileRouteBuilder extends RouteBuilder {

    @Autowired
    private ExtentionHeaderSettingProcessor extentionHeaderSettingProcessor;
    @Autowired
    private ExtentionHeaderPrintingProcessor extentionHeaderPrintingProcessor;

    @Override
    public void configure() throws Exception {
        from("file:sampleDirectory/from")
            .process(extentionHeaderPrintingProcessor)
            .process(extentionHeaderSettingProcessor)
            .process(extentionHeaderPrintingProcessor)
        .to("file:sampleDirectory/to");
    }
}