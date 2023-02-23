package no.promon;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.enterprise.context.control.ActivateRequestContext;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import no.promon.client.YrClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import schema.Weatherdata;

import javax.inject.Inject;
import java.io.StringReader;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    @RestClient
    YrClient yrClient;

    @Override
    @ActivateRequestContext
    public int run(String... args) throws Exception {

        CommandHandler commandHandler = new CommandHandler();
        Double lat = null;
        Double lon = null;

        if (args.length == 0) {
            Quarkus.waitForExit();
            return 0;
        }
        if (args.length == 2) {
            try {
                lat = Double.parseDouble(args[0]);
                lon = Double.parseDouble(args[1]);

                commandHandler.readCommands(requestForecast(lat, lon));
            }catch(NumberFormatException nfe){
                System.out.println("Format of coordinates not Valid!");
                Quarkus.waitForExit();
            }catch (JAXBException je){
                System.out.println("Error casting HTTP response");
                Quarkus.waitForExit();
            }
        }

        return 0;
    }

    private Weatherdata requestForecast(Double lat, Double lon) throws JAXBException {
        String response = yrClient.getForecast(lat, lon);
        JAXBContext jaxbContext = JAXBContext.newInstance(Weatherdata.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        StringReader reader = new StringReader(response);
        return (Weatherdata) unmarshaller.unmarshal(reader);
    }

}