package gorzela.izabela.CamelDemo.processors;

import gorzela.izabela.CamelDemo.headers.FileNameExtention;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class ExtentionHeaderPrintingProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        FileNameExtention extentionHeader = exchange.getMessage().getHeader(FileNameExtention.FILE_EXTENTION_HEADER, FileNameExtention.class);
        if(extentionHeader == null) {
            System.out.println("Extention Header is not set");
        }
        else {
            System.out.println("Extention Header: " + extentionHeader);
        }
    }
}