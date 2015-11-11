/*=========================================================================
 *
 *  PROJECT:  MaxiCM
 *            MaxiCM Team (http://www.MaxiCM.com)
 *
 *  COPYRIGHT Copyright (C) 2015 MaxiCM http://www.MaxiCM.com
 *            All rights reserved
 *
 *  LICENSE   http://www.gnu.org/licenses/gpl-2.0.html GNU/GPL
 *
 *  AUTHORS:     MaxiCM Team, XperiAMM
 *  DESCRIPTION: MaxiOTA keeps our rom up to date
 *
 *=========================================================================
 */

package com.maxi.ota.updater;

import android.content.Intent;
import android.util.Log;

import com.commonsware.cwac.wakeful.WakefulIntentService;

public class UpdateService extends WakefulIntentService {
    private static final String TAG = "UpdateService";

    private static boolean mNoLog = true;

    public UpdateService(String name) {
        super(name);
    }

    public UpdateService() {
        super("MaxiOtaService");
    }

    /* (non-Javadoc)
     * @see com.commonsware.cwac.wakeful.WakefulIntentService#doWakefulWork(android.content.Intent)
     */
    @Override
    protected void doWakefulWork(Intent intent) {
       if (mNoLog == false) Log.d(TAG, "Maxi OTA Update service called!");
       UpdateChecker otaChecker = new UpdateChecker();
       otaChecker.execute(getBaseContext());
    }

}
