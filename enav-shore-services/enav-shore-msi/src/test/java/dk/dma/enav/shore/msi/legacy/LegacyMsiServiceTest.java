/* Copyright (c) 2011 Danish Maritime Authority
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this library.  If not, see <http://www.gnu.org/licenses/>.
 */
package dk.dma.enav.shore.msi.legacy;

import javax.inject.Inject;

import org.jglue.cdiunit.AdditionalClasses;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;

import dk.dma.enav.shore.common.config.LogConfiguration;

/**
 * Tests the {@linkplain LegacyMsiService} class
 */
@RunWith(CdiRunner.class)
@AdditionalClasses(value = { LegacyMsiService.class, LogConfiguration.class })
public class LegacyMsiServiceTest {

    @Inject
    Logger log;
    
    @Inject
    LegacyMsiService msiService;
    
    @Test
    public void test() {

        // Point to the test service
        msiService.endpoint = "http://msi-beta.e-navigation.net/msi/ws/warning";
        msiService.countries = "DK";

        log.info(String.format("Fetched %d legacy MSI warnings from endpoint %s and country %s",
                msiService.getActiveWarnings().size(), msiService.endpoint, msiService.countries));
    }
}
