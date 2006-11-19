/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package wicket.settings;

/**
 * Framework settings for retrieving and configuring framework settings.
 *
 * @author Martijn Dashorst
 */
public interface IFrameworkSettings
{
	/**
	 * Gets the Wicket version. The Wicket version is in the same format as the
	 * version element in the pom.xml file (project descriptor). The version is
	 * generated by maven in the build/release cycle and put in the wicket.properties
	 * file located in the root folder of the Wicket jar.
	 * 
	 * The version usually follows one of the following formats: 
	 * <ul>
	 * <li>major.minor[.bug] for stable versions. 1.1, 1.2, 1.2.1 are examples</li>
	 * <li>major.minor-state for development versions. 1.2-beta2, 1.3-SNAPSHOT are examples</li>
	 * </ul>
	 *
	 * @return the Wicket version
	 */
	public String getVersion();
}
