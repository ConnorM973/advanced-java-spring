/* CodingNomads (C)2024 */
package com.codingnomads.corespring.examples.propertysourceannotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class App {
    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    @Value("${appexample.name}")
    private String appExampleName;

    @Value("${appexample.version}")
    private String appExampleVersion;

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public String getAppExampleName() {
        return appExampleName;
    }

    public String getAppExampleVersion() {
        return appExampleVersion;
    }
}
