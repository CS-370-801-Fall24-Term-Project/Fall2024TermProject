import config from '../config/config.json'

export function getServerUrl() {
    /* eslint-disable */
    const serverProtocol = location.protocol;
    const serverHost = location.hostname;
    const serverPort = location.port;
    const alternatePort = config.server_port; // process.env.SERVER_PORT;
    return `${serverProtocol}\/\/${serverHost}:${(!alternatePort ? serverPort : alternatePort)}`;
    /* eslint-enable */
}

export async function sendAPIRequest(requestBody, serverUrl, endpoint, ...params) {
    const response = await sendRequest(requestBody, serverUrl, endpoint, params);
    // if (response !== null && isRequestNotSupported(requestBody)) {
    // if (response !== null && isRequestNotSupported(requestBody)) {
    //     throw new Error(`sendAPIRequest() does not have support for type: ${requestBody.requestType}. Please add the schema to 'SCHEMAS'.`);
    // }
    // if (response !== null && isJsonResponseValid(response, SCHEMAS[requestBody.requestType])) {
    if (response !== null) {
        return response;
    }
    throw new Error(`Server response(${requestBody}) response is invalid. Check the Server.`);
    return null;
}

async function sendRequest(requestBody, serverUrl, endpoint, ...params) {
    const fetchOptions = {
        method: "POST",
        body: JSON.stringify(requestBody)
    };

    try {
        let queryString = buildQueryString(params);
        const response = await fetch(`${serverUrl}/${endpoint}`, fetchOptions);
        if (response.ok) {
            return response.json();
        } else {
            throw new Error(`Request to server ${serverUrl} failed: ${response.status}: ${response.statusText}`);
        }

    } catch (err) {
        throw new Error(`Request to server failed : ${err}`);
    }

    return null;
}

function buildQueryString(...params) {
    let result = "";
    if (params != null && params.length > 0) {
        result = params.reduce((queryString, [key, value]) => {
            return queryString + `${key}=${encodeURIComponent(value)}`
        });
    }
    return result;
}
