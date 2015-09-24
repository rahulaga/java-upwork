/**
 * Copyright 2014 Upwork
 *
 * Licensed under the Upwork's API Terms of Use;
 * you may not use this file except in compliance with the Terms.
 * You may obtain a copy of the Terms at
 * 
 *    https://developers.upwork.com/api-tos.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.Upwork.api.Routers.Activities;

import java.util.HashMap;

import com.Upwork.ClassPreamble;
import com.Upwork.api.OAuthClient;

import org.json.JSONException;
import org.json.JSONObject;

@ClassPreamble (
	author = "Maksym Novozhylov <mnovozhilov@upwork.com>",
	date = "6/4/2014",
	currentRevision = 1,
	lastModified = "24/09/2015",
	lastModifiedBy = "Maksym Novozhylov",
	reviewers = {"Yiota Tsakiri"}
)
public final class Engagement {
	
	final static String ENTRY_POINT = "api";
	
	private OAuthClient oClient = null;

	public Engagement(OAuthClient client) {
		oClient = client;
		oClient.setEntryPoint(ENTRY_POINT);
	}
	
	/**
     * List activities for specific engagement
     *
     * @param   engagement_ref Engagement reference
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getSpecific(String engagement_ref) throws JSONException {
        return oClient.get("/tasks/v2/tasks/contracts/" + engagement_ref);
    }
    
    /**
     * Assign engagements to the list of activities
     *
     * @param   company Company ID
     * @param	team Team ID
     * @param   engagement Engagement
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject assign(String company, String team, String engagement, HashMap<String, String> params) throws JSONException {
        return oClient.put("/otask/v1/tasks/companies/" + company + "/teams/" + team + "/engagements/" + engagement + "/tasks", params);
    }
    
    /**
     * Assign engagements to the list of activities
     *
     * @param   engagement_ref Engagement reference
     * @param   params Parameters
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject assignToEngagement(String engagement_ref, HashMap<String, String> params) throws JSONException {
        return oClient.get("/tasks/v2/tasks/contracts/" + engagement_ref, params);
    }

}
