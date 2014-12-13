/**
 * Copyright [2014] Gaurav Gupta
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.netbeans.modeler.properties.nentity;

import java.util.List;

public interface NEntityDataListener {

    void initData();

    void initCount();

    int getCount();

    List<Object[]> getData();

    void setData(java.util.List<Object[]> data);

//    List<T> getEntities();
//
//    void setEntities(List<T> entities);
//
//    Object[] getRow(T entity);
//
//    T getEntity(Object[] row);
}