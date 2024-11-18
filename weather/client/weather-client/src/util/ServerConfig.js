import React, { useEffect, useState } from 'react';
import { getServerUrl } from './restApi';

export function useServerSettings(showMessage) {
	const [serverUrl, setServerUrl] = useState(getServerUrl());
	const [serverConfig, setServerConfig] = useState(null);

	useEffect(() => {
		// sendConfigRequest();
	}, []);

    function processServerConfigSuccess(config, url) {
        // LOG.info('Switching to Server:', url);
        setServerConfig(config);
        setServerUrl(url);
    }

    async function sendConfigRequest() {
        const configResponse = await sendAPIRequest({ requestType: 'config' },serverUrl);
        if (configResponse) {
            processServerConfigSuccess(configResponse, serverUrl);
        } else {
            setServerConfig(null);
            showMessage(`Config request to ${serverUrl} failed. Check the log for more details.`, 'error');
        }
    }

	return [{ serverUrl: serverUrl, serverConfig: serverConfig }, processServerConfigSuccess,];
}