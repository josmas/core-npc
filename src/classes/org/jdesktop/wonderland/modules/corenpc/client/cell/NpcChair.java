/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jdesktop.wonderland.modules.corenpc.client.cell;

import com.jme.math.Vector3f;
import imi.objects.ChairObject;
import imi.objects.ObjectCollectionBase;
import imi.objects.SpatialObject;
import imi.scene.PSphere;
import imi.scene.polygonmodel.PPolygonModelInstance;

/**
 *
 * @author Morris Ford
 */
public class NpcChair implements ChairObject
    {
    private boolean chairOccupied = false;
    private SpatialObject chairOwner = null;
    private Vector3f chairPosition;
    private Vector3f chairHeading;
    private String chairPath;

    public NpcChair(Vector3f position, Vector3f heading, String modelPath)
        {
        chairPosition = position;
        chairHeading = heading;
        chairPath = modelPath;
        }

    public NpcChair(Vector3f position, Vector3f heading)
        {
        chairPosition = position;
        chairHeading = heading;
        }

    public float getDesiredDistanceFromOtherTargets()
        {
        throw new UnsupportedOperationException("Not supported yet.");
        }

    public Vector3f getTargetPositionRef()
        {
        return chairPosition;
        }

    public Vector3f getTargetForwardVector()
        {
        return chairHeading;
        }

    public SpatialObject getOwner()
        {
        return chairOwner;
        }

    public void setOwner(SpatialObject owner)
        {
        chairOwner = owner;
        }

    public boolean isOccupied()
        {
        return false;
        }

    public boolean isOccupied(boolean arg0)
        {
        return false;
        }

    public void setOccupied(boolean occupied)
        {
        chairOccupied = occupied;
        }

    public void destroy()
        {
        throw new UnsupportedOperationException("Not supported yet.");
        }

    public PPolygonModelInstance getModelInst()
        {
        throw new UnsupportedOperationException("Not supported yet.");
        }

    public PSphere getBoundingSphere()
        {
        throw new UnsupportedOperationException("Not supported yet.");
        }

    public PSphere getNearestObstacleSphere(Vector3f arg0)
        {
        throw new UnsupportedOperationException("Not supported yet.");
        }

    public void setObjectCollection(ObjectCollectionBase arg0)
        {
        throw new UnsupportedOperationException("Not supported yet.");
        }

    public Vector3f getPositionRef()
        {
        throw new UnsupportedOperationException("Not supported yet.");
        }

    public Vector3f getRightVector()
        {
        throw new UnsupportedOperationException("Not supported yet.");
        }

    public Vector3f getForwardVector()
        {
        throw new UnsupportedOperationException("Not supported yet.");
        }
    }
