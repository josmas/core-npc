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
package org.jdesktop.wonderland.modules.corenpc.common;

import javax.xml.bind.annotation.XmlRootElement;
import org.jdesktop.wonderland.common.cell.ComponentLookupClass;
import org.jdesktop.wonderland.common.cell.state.annotation.ServerState;
import org.jdesktop.wonderland.modules.avatarbase.common.cell.AvatarConfigComponentServerState;

/**
 * Server state for NPC avatar configuration component
 *
 * @author Jordan Slot <jslott@dev.java.net>
 */
@XmlRootElement(name="npc-avatar-config-component")
@ServerState
@ComponentLookupClass(AvatarConfigComponentServerState.class)
public class NpcAvatarConfigComponentServerState extends AvatarConfigComponentServerState {

    /** Default constructor */
    public NpcAvatarConfigComponentServerState() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getServerComponentClassName() {
        return "org.jdesktop.wonderland.modules.corenpc.server.cell.NpcAvatarConfigComponentMO";
    }
}
