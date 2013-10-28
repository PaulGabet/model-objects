/*
 * Copyright (c) 2013, Regents of the University of California
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package edu.berkeley.path.model_objects.dynamic;

import edu.berkeley.path.model_objects.scenario.DemandProfile;
import edu.berkeley.path.model_objects.shared.CrudFlag;
import edu.berkeley.path.model_objects.shared.DateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a dynamic demand set obtained from the Boundary Flow Engine
 * It is identical to the regular DemandSet object, the only differences are:
 * Data is coming from the engine, instead of manually crafted
 * They are stored in a separate DYNAMIC_DEMAND_SETS table
 * It has two extra fields:
 *  appRunId is the runId of the origin estimation run that produces this dynamic demand set
 *  estTstamp is the simulation time for that run, when the dynamic demand set was produced
 */
public class DynamicDemandSet extends edu.berkeley.path.model_objects.jaxb.DynamicDemandSet {

  /**
   * Get App run id
   *
   * @return app run id
   */
  @Override
  public long getAppRunId() {
    return appRunId;
  }

  /**
   * Set App run id
   *
   * @param value representing app run id
   */
  @Override
  public void setAppRunId(long value) {
    this.appRunId = value;
  }

  /**
   * Get Estimation timestamp as represented in number of seconds since epoch
   *
   * @return date time object
   */
  public DateTime getEstimationTstamp() {
    return (DateTime) estTstamp;
  }

  /**
   * Set Estimation timestamp as represented in number of seconds since epoch
   *
   * @param value representing date time object
   */
  public void setEstimationTstamp(DateTime value) {
    this.estTstamp = value;
  }

  /**
     * Get modstamp
     * @return modstamp
     */
    @Override
    public String getModStamp() {
      return modStamp;
    }

    /**
     * Set modstamp
     * @param value new modstamp
     */
    @Override
    public void setModStamp(String value) {
      this.modStamp = value;
    }

    /**
     * Get CRUD (Create, Retrieve, Update, Delete) Action Flag for object
     *
     * @return CRUD Flag enumeration
     */
    public CrudFlag getCrudFlagEnum() {

      CrudFlag flag = null;
      // Check if CRUDFlag is null, if so return NONE enumeration
      if (super.getCrudFlag() == null) {
        setCrudFlagEnum(CrudFlag.NONE);
        flag = CrudFlag.NONE;
      }
      else {
        switch (CrudFlag.valueOf(super.getCrudFlag())) {
          case CREATE:
            flag = CrudFlag.CREATE;
            break;
          case RETRIEVE:
            flag = CrudFlag.RETRIEVE;
            break;
          case UPDATE:
            flag = CrudFlag.UPDATE;
            break;
          case DELETE:
            flag = CrudFlag.DELETE;
            break;
          default:
            flag = CrudFlag.NONE;
            break;

        }
      }
      return flag;
    }

    /**
     * Set CRUD (Create, Retrieve, Update, Delete) Action Flag for object
     *
     * @param flag Flag enumeration
     */
    public void setCrudFlagEnum(edu.berkeley.path.model_objects.shared.CrudFlag flag) {
      // Check if CRUDFlag is null, if so return NONE enumeration
      if (flag == null) {
        super.setCrudFlag("NONE");
      }
      else {
        switch (flag) {
          case CREATE:
            super.setCrudFlag("CREATE");
            break;
          case RETRIEVE:
            super.setCrudFlag("RETRIEVE");
            break;
          case UPDATE:
            super.setCrudFlag("UPDATE");
            break;
          case DELETE:
            super.setCrudFlag("DELETE");
            break;
          default:
            super.setCrudFlag("NONE");
            break;

        }
      }
    }
    /**
     * Gets the value of the description property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    @Override
    public String getDescription() {
      return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    @Override
    public void setDescription(String value) {
      this.description = value;
    }

    /**
     * Get DemandProfile list
     * @return DemandProfile list
     */
    @SuppressWarnings("unchecked")
    public List<DemandProfile> getDemandProfileList() {

      if (dynamicDemandProfile == null) {

        dynamicDemandProfile = new ArrayList<edu.berkeley.path.model_objects.jaxb.DynamicDemandProfile>();
      }
      return (List<DemandProfile>)(List<?>)this.dynamicDemandProfile;
    }

    /**
     * Set DemandProfile list
     * @param dpList list
     */
    @SuppressWarnings("unchecked")
    public void setDemandProfileList(List<DemandProfile> dpList) {

      if ( dynamicDemandProfile == null ) {

        dynamicDemandProfile = new ArrayList<edu.berkeley.path.model_objects.jaxb.DynamicDemandProfile>();
      }
      dynamicDemandProfile.clear();
      dynamicDemandProfile.addAll((List<edu.berkeley.path.model_objects.jaxb.DynamicDemandProfile>)(List<?>)dpList);
    }


    /**
     * Gets the value of the id property.
     *
     */
    @Override
    public long getId() {
      return id;
    }

    /**
     * Sets the value of the id property.
     *
     */
    @Override
    public void setId(long value) {
      this.id = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    @Override
    public String getName() {
      if (name == null) {
        return "";
      } else {
        return name;
      }
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    @Override
    public void setName(String value) {
      this.name = value;
    }

    /**
     * Gets the value of the lockedForEdit property.
     *
     * @return boolean
     *
     */
    @Override
    public boolean isLockedForEdit() {
      return super.isLockedForEdit();
    }

    /**
     * Sets the value of the lockedForEdit property.
     *
     * @param value locked flag
     *
     */
    @Override
    public void setLockedForEdit(Boolean value) {
      super.setLockedForEdit(value);
    }

    /**
     * Gets the value of the lockedForHistory property.
     *
     * @return boolean
     *
     */
    @Override
    public boolean isLockedForHistory() {
      return super.isLockedForHistory();
    }

    /**
     * Sets the value of the lockedForHistory property.
     *
     * @param value locked flag
     *
     */
    @Override
    public void setLockedForHistory(Boolean value) {
      super.setLockedForHistory(value);
    }

    /**
     * Ensures all required fields are set
     *
     * @return True if valid
     */
    public boolean isValid(){
      // TODO - validation logic
      return true;
    }

    /**
     * Gets the value of the demandProfile property.
     *
     *
     * @return List<DemandProfile>
     *
     *
     */
    @SuppressWarnings("unchecked")
    public List<DynamicDemandProfile> getListOfDemandProfiles() {
      // return casted list of Nodes from JAXB base class
      return (List<DynamicDemandProfile>)(List<?>)super.getDynamicDemandProfile();
    }

    /**
     * Set the demands profiles list. Attaches list of Demand Profile Model Objects to set.
     *
     * @param demands	List of extended Demand Profiles to add
     */
    @SuppressWarnings("unchecked")
    public void setListOfDemandProfiles(List<DynamicDemandProfile> demands) {
      List<edu.berkeley.path.model_objects.jaxb.DynamicDemandProfile> profiles = super.getDynamicDemandProfile();
      if ( profiles == null ) {
        profiles = new ArrayList<edu.berkeley.path.model_objects.jaxb.DynamicDemandProfile>();
      }
      profiles.clear();
      profiles.addAll((List<edu.berkeley.path.model_objects.jaxb.DynamicDemandProfile>)(List<?>)demands);
      super.dynamicDemandProfile = profiles;
    }


    /**
     * Get the profile at the specified link.
     * Returns DemandProfile associated with link id passed in.
     * If there are no profiles associated with this link id null is returned.
     *
     * @param linkId get demand profile associated with the link id
     * @return DemandProfile or null if not found
     */
    public DynamicDemandProfile getDemandProfileAtLink(long linkId) {

      for(DynamicDemandProfile p : getListOfDemandProfiles()) {
        if(p.getLinkIdOrg() == linkId) {
          return p;
        }
      }
      // Otherwise not found so return null
      return null;
    }
}
