/*
 * Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.extension.siddhi.execution.test.volume;

import org.apache.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.wso2.siddhi.core.SiddhiAppRuntime;
import org.wso2.siddhi.core.SiddhiManager;
import org.wso2.siddhi.core.event.Event;
import org.wso2.siddhi.core.query.output.callback.QueryCallback;
import org.wso2.siddhi.core.stream.input.InputHandler;
import org.wso2.siddhi.core.util.EventPrinter;

/**
 * Test for UnitConversion LitreToMillilitre function
 */
public class LitreToMillilitreTestCase {

    private static Logger logger = Logger.getLogger(LitreToMillilitreTestCase.class);
    protected static SiddhiManager siddhiManager;

    @Test
    public void testProcessForLitreToMillilitre() throws Exception {
        logger.info("UnitConversionForLitreToMillilitreFunctionExtension TestCase");

        siddhiManager = new SiddhiManager();
        String siddhiApp = "define stream UnitConversionForLitreToMillilitreStream (inValue int); ";

        String eventFuseSiddhiApp = ("@info(name = 'query1') from UnitConversionForLitreToMillilitreStream "
                + " select unitconversion:lToml(inValue) "
                + "as UnitConversionValue "
                + " insert into OutMediationStream;");
        SiddhiAppRuntime siddhiAppRuntime = siddhiManager
                .createSiddhiAppRuntime(siddhiApp + eventFuseSiddhiApp);

        siddhiAppRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents,
                                Event[] removeEvents) {
                EventPrinter.print(timeStamp, inEvents, removeEvents);
                Double result;
                for (Event event : inEvents) {
                    result = (Double) event.getData(0);
                    AssertJUnit.assertEquals((Double) 1000.0, result);
                }
            }
        });
        InputHandler inputHandler = siddhiAppRuntime.getInputHandler("UnitConversionForLitreToMillilitreStream");
        siddhiAppRuntime.start();
        inputHandler.send(new Object[]{1.0});
        Thread.sleep(100);
        siddhiAppRuntime.shutdown();
    }

    @Test
    public void testProcessForLitreToMillilitre2() throws Exception {
        logger.info("UnitConversionForForLitreToMillilitreFunctionExtension2 TestCase");

        siddhiManager = new SiddhiManager();
        String siddhiApp = "define stream UnitConversionForLitreToMillilitreStream (inValue int); ";

        String eventFuseSiddhiApp = ("@info(name = 'query1') from UnitConversionForLitreToMillilitreStream "
                + " select unitconversion:lToml(inValue) "
                + "as UnitConversionValue "
                + " insert into OutMediationStream;");
        SiddhiAppRuntime siddhiAppRuntime = siddhiManager
                .createSiddhiAppRuntime(siddhiApp + eventFuseSiddhiApp);

        siddhiAppRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents,
                                Event[] removeEvents) {
                EventPrinter.print(timeStamp, inEvents, removeEvents);
                Double result;
                for (Event event : inEvents) {
                    result = (Double) event.getData(0);
                    AssertJUnit.assertEquals((Double) 0.0, result);
                }
            }
        });
        InputHandler inputHandler = siddhiAppRuntime.getInputHandler("UnitConversionForLitreToMillilitreStream");
        siddhiAppRuntime.start();
        inputHandler.send(new Object[]{0});
        Thread.sleep(100);
        siddhiAppRuntime.shutdown();
    }

    @Test
    public void testProcessForLitreToMillilitre3() throws Exception {
        logger.info("UnitConversionForForLitreToMillilitreFunctionExtension3 TestCase");

        siddhiManager = new SiddhiManager();
        String siddhiApp = "define stream UnitConversionForLitreToMillilitreStream (inValue int); ";

        String eventFuseSiddhiApp = ("@info(name = 'query1') from UnitConversionForLitreToMillilitreStream "
                + " select unitconversion:lToml(inValue) "
                + "as UnitConversionValue "
                + " insert into OutMediationStream;");
        SiddhiAppRuntime siddhiAppRuntime = siddhiManager
                .createSiddhiAppRuntime(siddhiApp + eventFuseSiddhiApp);

        siddhiAppRuntime.addCallback("query1", new QueryCallback() {
            @Override
            public void receive(long timeStamp, Event[] inEvents,
                                Event[] removeEvents) {
                EventPrinter.print(timeStamp, inEvents, removeEvents);
                Double result;
                for (Event event : inEvents) {
                    result = (Double) event.getData(0);
                    AssertJUnit.assertEquals((Double) 2.147483647E12, result);
                }
            }
        });
        InputHandler inputHandler = siddhiAppRuntime.getInputHandler("UnitConversionForLitreToMillilitreStream");
        siddhiAppRuntime.start();
        inputHandler.send(new Object[]{2147483647});
        Thread.sleep(100);
        siddhiAppRuntime.shutdown();
    }
}
