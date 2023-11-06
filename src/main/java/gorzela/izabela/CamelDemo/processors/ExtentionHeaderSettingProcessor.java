package gorzela.izabela.CamelDemo.processors;

import gorzela.izabela.CamelDemo.headers.FileNameExtention;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class ExtentionHeaderSettingProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String fileName = exchange.getMessage().getHeader(Exchange.FILE_NAME, String.class);
        String[] splittedHeaderName = fileName.split("\\.");
        String fileExtention = splittedHeaderName[splittedHeaderName.length - 1];
        if (fileExtention.equalsIgnoreCase("txt") || fileExtention.equalsIgnoreCase("csv") && splittedHeaderName.length != 1) {
            exchange.getMessage().setHeader(FileNameExtention.FILE_EXTENTION_HEADER, FileNameExtention.valueOf(fileExtention.toUpperCase()));
        }
        else{
                exchange.getMessage().setHeader(FileNameExtention.FILE_EXTENTION_HEADER, FileNameExtention.valueOf("OTHER"));
            }
        }
    }