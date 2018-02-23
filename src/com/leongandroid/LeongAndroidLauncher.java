/*
 * Copyright (C) LeongAndroid
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.leongandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.android.launcher3.AppInfo;
import com.android.launcher3.BuildConfig;
import com.android.launcher3.InstallShortcutReceiver;
import com.android.launcher3.Launcher;
import com.android.launcher3.LauncherAppState;
import com.android.launcher3.LauncherCallbacks;
import com.android.launcher3.R;
import com.android.launcher3.util.ComponentKeyMapper;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class LeongAndroidLauncher extends Launcher {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLauncherCallbacks(new LeongAndroidLauncherCallbacks());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void startBinding() {
        super.startBinding();
    }

    @Override
    public void finishBindingItems() {
        super.finishBindingItems();
    }

    private class LeongAndroidLauncherCallbacks implements LauncherCallbacks {
        private ArrayList<AppInfo> mApps;
        @Override
        public void preOnCreate() {

        }

        @Override
        public void onCreate(Bundle savedInstanceState) {

        }

        @Override
        public void preOnResume() {
            findViewById(R.id.page_indicator_no_drawer).setVisibility(BuildConfig.HASDRAWER ? View.GONE : View.VISIBLE);
            if (mAllAppsButton != null) {
                mAllAppsButton.setVisibility(BuildConfig.HASDRAWER ? View.VISIBLE : View.GONE);
            }
        }

        @Override
        public void onResume() {

        }

        @Override
        public void onStart() {

        }

        @Override
        public void onStop() {

        }

        @Override
        public void onPause() {

        }

        @Override
        public void onDestroy() {

        }

        @Override
        public void onSaveInstanceState(Bundle outState) {

        }

        @Override
        public void onPostCreate(Bundle savedInstanceState) {

        }

        @Override
        public void onNewIntent(Intent intent) {

        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {

        }

        @Override
        public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        }

        @Override
        public void onWindowFocusChanged(boolean hasFocus) {

        }

        @Override
        public void onAttachedToWindow() {

        }

        @Override
        public void onDetachedFromWindow() {

        }

        @Override
        public boolean onPrepareOptionsMenu(Menu menu) {
            return false;
        }

        @Override
        public void dump(String prefix, FileDescriptor fd, PrintWriter w, String[] args) {

        }

        @Override
        public void onHomeIntent() {

        }

        @Override
        public boolean handleBackPressed() {
            return false;
        }

        @Override
        public void onTrimMemory(int level) {

        }

        @Override
        public void onLauncherProviderChange() {

        }

        @Override
        public void finishBindingItems(boolean upgradePath) {

        }

        @Override
        public void bindAllApplications(ArrayList<AppInfo> apps) {
            mApps = apps;
            boolean hasDrawer = BuildConfig.HASDRAWER;
            if (!hasDrawer) {
                LauncherAppState.getInstance(LeongAndroidLauncher.this).getModel().
                        addAndBindAddedWorkspaceItems(new InstallShortcutReceiver.LeongLazyShortcutsProvider(getApplicationContext(), mApps));
            }
        }

        @Override
        public void bindAppsAddedOrUpdated(ArrayList<AppInfo> apps) {
            if (apps != null && apps.size() > 0) {
                if (!BuildConfig.HASDRAWER) {
                    LauncherAppState.getInstance(LeongAndroidLauncher.this).getModel().
                            addAndBindAddedWorkspaceItems(new InstallShortcutReceiver.LeongLazyShortcutsProvider(getApplicationContext(), apps));
                }
            }
        }

        @Override
        public void onInteractionBegin() {

        }

        @Override
        public void onInteractionEnd() {

        }

        @Override
        public void onWorkspaceLockedChanged() {

        }

        @Override
        public boolean startSearch(String initialQuery, boolean selectInitialQuery, Bundle appSearchData) {
            return false;
        }

        @Override
        public boolean hasCustomContentToLeft() {
            return false;
        }

        @Override
        public void populateCustomContentContainer() {

        }

        @Override
        public View getQsbBar() {
            return null;
        }

        @Override
        public Bundle getAdditionalSearchWidgetOptions() {
            return null;
        }

        @Override
        public boolean shouldMoveToDefaultScreenOnHomeIntent() {
            return true;
        }

        @Override
        public boolean hasSettings() {
            return true;
        }

        @Override
        public List<ComponentKeyMapper<AppInfo>> getPredictedApps() {
            return null;
        }

        @Override
        public int getSearchBarHeight() {
            return 0;
        }
    }

}
