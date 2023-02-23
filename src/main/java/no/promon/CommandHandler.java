package no.promon;

import io.quarkus.runtime.Startup;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import schema.*;

import javax.inject.Named;
import java.time.Instant;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.Scanner;


public class CommandHandler {

    //@Produces
    private static Weatherdata weatherdata;

    public CommandHandler(){};

    void readCommands( Weatherdata weatherdata) throws JAXBException {
        String command = "";
        Scanner sc =new Scanner(System.in);
        this.weatherdata=weatherdata;

        while (!"exit".equals(command)){
            System.out.print(">>> ");
            command = sc.nextLine();

            if ("--help".equals(command)) {
                System.out.println(
                        "This tool helps give you the forecast for the next days\n" +
                        "Available commands:\n" +
                        "\t--help\t\t\tShow help message\n" +
                        "\t--d={day}\t\tGives you the forecast for the number of days starting today. ex: forecast for today \'--d 1\'"
                );
            }
            if (command.startsWith("--d")) {
                try{
                    Integer days= Integer.parseInt(command.substring(4));
                    System.out.println(printForecast(days));
                }catch (NumberFormatException nfe){
                    System.out.println("parameter invalid");
                }
            }
        }
    }

    public String printForecast(Integer days) {


        String forecast = "";

        Optional<ProductType> productType =weatherdata.getProduct().stream()
                .filter(product -> product.getClazz().equals("pointData"))
                .findFirst();

        if(productType.isPresent()) {
            Instant instant = Instant.now().atZone(ZoneId.systemDefault()).toInstant();
            instant = instant.plus(days, ChronoUnit.DAYS);
            for (TimeType timeType : productType.get().getTime()) {
                Instant convertedXmlDateTimeFrom = timeType.getFrom()
                        .toGregorianCalendar()
                        .toZonedDateTime()
                        .withZoneSameLocal(ZoneId.systemDefault())
                        .toInstant();
                Instant convertedXmlDateTimeTo = timeType.getTo()
                        .toGregorianCalendar()
                        .toZonedDateTime()
                        .withZoneSameLocal(ZoneId.systemDefault())
                        .toInstant();
                if(convertedXmlDateTimeFrom.isBefore(instant) &&
                        ChronoUnit.HOURS.between(convertedXmlDateTimeFrom, convertedXmlDateTimeTo) == 1) {
                    forecast += "\nForcast for day: " + timeType.getFrom().getDay() +
                            "/" + timeType.getFrom().getMonth() +
                            " and period from " + timeType.getFrom().getHour() +
                            " to " + timeType.getTo().getHour() + " is :";
                    for (JAXBElement jaxbElement : timeType.getLocation().get(0).getGroundCoverAndPressureAndMaximumPrecipitation()) {
                        if (jaxbElement.getValue().getClass().equals(Precipitation.class))
                            forecast += "\n\t" + jaxbElement.getName() + " -> "
                                    + ((Precipitation) jaxbElement.getValue()).getValue()
                                    + ((Precipitation) jaxbElement.getValue()).getUnit();
                    }
                }
            }
        }
        return forecast;
    }
}
