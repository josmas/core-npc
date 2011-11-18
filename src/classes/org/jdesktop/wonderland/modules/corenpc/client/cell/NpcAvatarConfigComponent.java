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
package org.jdesktop.wonderland.modules.corenpc.client.cell;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.wonderland.client.cell.Cell;
import org.jdesktop.wonderland.client.cell.asset.AssetUtils;
import org.jdesktop.wonderland.common.cell.ComponentLookupClass;
import org.jdesktop.wonderland.common.cell.state.CellComponentClientState;
import org.jdesktop.wonderland.modules.avatarbase.client.cell.AvatarConfigComponent;
import org.jdesktop.wonderland.modules.avatarbase.common.cell.AvatarConfigComponentClientState;
import org.jdesktop.wonderland.modules.avatarbase.common.cell.AvatarConfigInfo;

/**
 * A Cell component that represents the current avatar configured by the system
 * for NPCs.
 *
 * @author Jordan Slott <jslott@dev.java.net>
 */
@ComponentLookupClass(AvatarConfigComponent.class)
public class NpcAvatarConfigComponent extends AvatarConfigComponent {

    private static Logger logger =
            Logger.getLogger(NpcAvatarConfigComponent.class.getName());

    /** Constructor */
    public NpcAvatarConfigComponent(Cell cell) {
        super(cell);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setClientState(CellComponentClientState clientState) {
        // Intercept the setClientState() call and "annotate" the avatar
        // config URI with the server:port. This AvatarConfigComponent does
        // not do this.
        AvatarConfigComponentClientState acccs =
                (AvatarConfigComponentClientState)clientState;
        AvatarConfigInfo avatarConfigInfo = acccs.getAvatarConfigInfo();

        try {
            if (avatarConfigInfo != null) {
                String uri = avatarConfigInfo.getAvatarConfigURL();
                if (uri != null) {
                    logger.warning("SETTING CLIENT STATE " + uri);
                    URL url = AssetUtils.getAssetURL(uri, cell);
                    avatarConfigInfo = new AvatarConfigInfo(url.toExternalForm(),
                            avatarConfigInfo.getLoaderFactoryClassName());
                    acccs.setAvatarConfigInfo(avatarConfigInfo);
                }
            }
        } catch (MalformedURLException ex) {
            logger.log(Level.WARNING, "Unable to form URL", ex);
        }

        super.setClientState(clientState);
    }
}
