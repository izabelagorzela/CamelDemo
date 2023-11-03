package gorzela.izabela.CamelDemo.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class FileNameChangingProcessor implements Processor {

    private Integer counter = 0;
    @Override
    public void process(Exchange exchange) throws Exception {
        String fileName = exchange.getMessage().getHeader(Exchange.FILE_NAME, String.class);
        counter += 1;
        String changedFileName = counter + "_" + fileName;
        exchange.getMessage().setHeader(Exchange.FILE_NAME, changedFileName);
    }
}
