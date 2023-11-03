package gorzela.izabela.CamelDemo.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class SimplePrintingProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("The file name: " + exchange.getMessage().getHeader(Exchange.FILE_NAME));
    }
}
