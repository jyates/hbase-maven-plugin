/**
 * Licensed to WibiData, Inc. under one or more contributor license
 * agreements.  See the NOTICE file distributed with this work for
 * additional information regarding copyright ownership.  WibiData, Inc.
 * licenses this file to you under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */

package org.kiji.maven.plugins.hbase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * A maven goal that stops the mini HBase cluster started by the 'start' goal.
 *
 * @goal stop
 * @phase post-integration-test
 */
public class StopMojo extends BaseClusterMojo {

  /** {@inheritDoc} */
  @Override
  public void execute() throws MojoExecutionException {
    if (mSkip) {
      getLog().info("Not stopping an HBase cluster because skip=true.");
      return;
    }
    saveHadoopTmpDirectory();
    MiniHBaseClusterSingleton.INSTANCE.stop(getLog());
  }
}
