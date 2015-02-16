/*
 *  Copyright (C) 2013 - 2015 Alexander "Evisceration" Martinz
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.namelessrom.devicecontrol.flasher;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RadioGroup;

import org.namelessrom.devicecontrol.R;
import org.namelessrom.devicecontrol.utils.PreferenceHelper;
import org.namelessrom.devicecontrol.utils.constants.DeviceConstants;

public class FlashOptionCard extends BaseCard {

    public FlashOptionCard(Context context) {
        super(context);
        LayoutInflater.from(context)
                .inflate(R.layout.merge_card_flasher_option, getContainer(), true);

        final int recoveryType = PreferenceHelper.getInt(DeviceConstants.PREF_RECOVERY_TYPE,
                DeviceConstants.RECOVERY_TYPE_OPEN);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_recovery_group);
        radioGroup.check(recoveryType == DeviceConstants.RECOVERY_TYPE_OPEN
                ? R.id.radio_recovery_openrecovery : R.id.radio_recovery_cwm);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override public void onCheckedChanged(RadioGroup group, int checkedId) {
                final int id = group.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.radio_recovery_cwm: {
                        PreferenceHelper.setInt(DeviceConstants.PREF_RECOVERY_TYPE,
                                DeviceConstants.RECOVERY_TYPE_CWM);
                        break;
                    }
                    case R.id.radio_recovery_openrecovery: {
                        PreferenceHelper.setInt(DeviceConstants.PREF_RECOVERY_TYPE,
                                DeviceConstants.RECOVERY_TYPE_OPEN);
                        break;
                    }
                }
            }
        });
    }


}
