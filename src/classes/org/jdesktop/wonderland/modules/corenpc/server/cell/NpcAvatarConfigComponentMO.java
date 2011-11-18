/**
 * Open Wonderland
 *
 * Copyright (c) 2010, Open Wonderland Foundation, All Rights Reserved
 *
 * Redistributions in source code form must reproduce the above
 * copyright and this condition.
 *
 * The contents of this file are subject to the GNU General Public
 * License, Version 2 (the "License"); you may not use this file
 * except in compliance with the License. A copy of the License is
 * available at http://www.opensource.org/licenses/gpl-license.php.
 *
 * The Open Wonderland Foundation designates this particular file as
 * subject to the "Classpath" exception as provided by the Open Wonderland
 * Foundation in the License file that accompanied this code.
 */

/**
 * Project Wonderland
 *
 * Copyright (c) 2004-2009, Sun Microsystems, Inc., All Rights Reserved
 *
 * Redistributions in source code form must reproduce the above
 * copyright and this condition.
 *
 * The contents of this file are subject to the GNU General Public
 * License, Version 2 (the "License"); you may not use this file
 * except in compliance with the License. A copy of the License is
 * available at http://www.opensource.org/licenses/gpl-license.php.
 *
 * Sun designates this particular file as subject to the "Classpath"
 * exception as provided by Sun in the License file that accompanied
 * this code.
 */
package org.jdesktop.wonderland.modules.corenpc.server.cell;

import java.util.logging.Logger;
import org.jdesktop.wonderland.common.cell.ClientCapabilities;
import org.jdesktop.wonderland.common.cell.ComponentLookupClass;
import org.jdesktop.wonderland.common.cell.state.CellComponentClientState;
import org.jdesktop.wonderland.common.cell.state.CellComponentServerState;
import org.jdesktop.wonderland.modules.avatarbase.common.cell.AvatarConfigComponentClientState;
import org.jdesktop.wonderland.modules.avatarbase.common.cell.AvatarConfigComponentServerState;
import org.jdesktop.wonderland.modules.avatarbase.server.cell.AvatarConfigComponentMO;
import org.jdesktop.wonderland.modules.corenpc.common.NpcAvatarConfigComponentServerState;
import org.jdesktop.wonderland.server.cell.CellMO;
import org.jdesktop.wonderland.server.comms.WonderlandClientID;

/**
 * A server-side Cell component that represents the current avatar configuration
 * for NPCs
 *
 * @author Jordan Slott <jslott@dev.java.net>
 */
@ComponentLookupClass(AvatarConfigComponentMO.class)
public class NpcAvatarConfigComponentMO extends AvatarConfigComponentMO {
    private static final Logger LOGGER =
            Logger.getLogger(NpcAvatarConfigComponentMO.class.getName());

    /** Constructor */
    public NpcAvatarConfigComponentMO(CellMO cell) {
        super(cell);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getClientClass() {
        return "org.jdesktop.wonderland.modules.corenpc.client.cell.NpcAvatarConfigComponent";
    }

    @Override
    public CellComponentClientState getClientState(CellComponentClientState clientState, WonderlandClientID clientID, ClientCapabilities capabilities) {
        CellComponentClientState res = super.getClientState(clientState, clientID, capabilities);

        LOGGER.warning("Client state: " + ((AvatarConfigComponentClientState) res).getAvatarConfigInfo().getAvatarConfigURL());

        return res;
    }

    @Override
    public void setServerState(CellComponentServerState state) {
        super.setServerState(state);

        LOGGER.warning("Set server state: " + ((AvatarConfigComponentServerState) state).getAvatarConfigInfo().getAvatarConfigURL());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CellComponentServerState getServerState(CellComponentServerState state) {
        // We need to override getServerState() so that we return the NPC version
        // of the component server state.
        if (state == null) {
            state = new NpcAvatarConfigComponentServerState();
        }
        return super.getServerState(state);
    }
}
