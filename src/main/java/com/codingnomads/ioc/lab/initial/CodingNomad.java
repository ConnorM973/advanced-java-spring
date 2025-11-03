package com.codingnomads.ioc.lab.initial;

import com.codingnomads.ioc.examples.setterinjection.Processor;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;


@Component
@RequiredArgsConstructor
public class CodingNomad {

    private final JDK jdk;
    private final IDE ide;
    private final Framework framework;
    private Desk desk;

   @Autowired
   private Coffee coffee;

    @Autowired
    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public String createAwesomeSoftware() {
        return MessageFormat.format(
                "This coding nomad is creating awesome software using, " +
                        "IDE: ({0}:{1}), JDK: ({2}:{3}), Framework: ({4}:{5}), Coffee: ({6}:{7}), Desk: ({8}:{9})",
                ide.getName(),
                ide.getVersion(),
                jdk.getName(),
                jdk.getVersion(),
                framework.getName(),
                framework.getVersion(),
                coffee.getCups(),
                coffee.getRoast(),
                desk.getType(),
                desk.getLength()
        );
    }
}
