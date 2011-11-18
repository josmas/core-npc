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

package org.jdesktop.wonderland.modules.corenpc.client.cell;

import imi.scene.PTransform;
import org.jdesktop.wonderland.client.cell.Cell;
import org.jdesktop.wonderland.client.cell.Cell.RendererType;
import org.jdesktop.wonderland.client.cell.CellRenderer;
import org.jdesktop.wonderland.client.cell.MovableAvatarComponent;
import org.jdesktop.wonderland.client.cell.MovableComponent;
import org.jdesktop.wonderland.client.cell.TransformChangeListener;
import org.jdesktop.wonderland.client.cell.TransformChangeListener.ChangeSource;
import org.jdesktop.wonderland.common.cell.CellTransform;
import org.jdesktop.wonderland.common.cell.ComponentLookupClass;
import org.jdesktop.wonderland.common.cell.messages.MovableAvatarMessage;
import org.jdesktop.wonderland.common.cell.messages.MovableMessage;
import org.jdesktop.wonderland.modules.avatarbase.client.jme.cellrenderer.AvatarImiJME;
import org.jdesktop.wonderland.modules.avatarbase.client.jme.cellrenderer.WlAvatarCharacter;

/**
 *
 * @author jkaplan
 */
@ComponentLookupClass(MovableComponent.class)
public class MovableNpcComponent extends MovableAvatarComponent {
    public MovableNpcComponent(Cell cell) {
        super (cell);
    }

    @Override
    public void localMoveRequest(CellTransform transform, int trigger,
                                 boolean pressed, String animationName,
                                 CellMoveModifiedListener listener)
    {
        super.localMoveRequest(transform, trigger, pressed, animationName, listener);

        CellRenderer renderer = cell.getCellRenderer(RendererType.RENDERER_JME);
        if (renderer instanceof AvatarImiJME) {
            WlAvatarCharacter character = ((AvatarImiJME) renderer).getAvatarCharacter();
            if (character != null) {
                character.getModelInst().setTransform(new PTransform(transform.getRotation(null),
                                                                     transform.getTranslation(null),
                                                                     transform.getScaling()));
            }
        }
    }

    void geometryChanged(CellTransform transform) {
        applyLocalTransformChange(transform, ChangeSource.LOCAL);
    }

    @Override
    protected void serverMoveRequest(MovableMessage msg) {
//        System.out.println("*****************************      serverMoveRequest");
        

 //       CellTransform transform = msg.getCellTransform();
 //       applyLocalTransformChange(transform, TransformChangeListener.ChangeSource.REMOTE);
 //       notifyServerCellMoveListeners(msg, transform, CellMoveSource.REMOTE);
/*
        MovableAvatarMessage mam = (MovableAvatarMessage) msg;
        if (mam.getTrigger() != NO_TRIGGER) {
            CellRenderer renderer = cell.getCellRenderer(RendererType.RENDERER_JME);
            if (renderer instanceof AvatarImiJME) {
                ((AvatarImiJME) renderer).trigger(mam.getTrigger(), mam.isPressed(), mam.getAnimationName());
            }
        }
*/
    }
}
