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

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import dk.frv.msiedit.core.webservice.message.MsiDto;

/**
 * Provides a simple REST interface for fetching legacy MSI warnings
 */
@Path("/legacy-msi")
public class LegacyMsiRestService {
    
    @Inject
    private LegacyMsiService msiClient;

    @GET
    @Path("/list")
    @Produces("application/json")
    public List<MsiDto> listActiveWarnings() {
        return msiClient.getActiveWarnings();
    }
}
