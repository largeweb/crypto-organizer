


import sys
import time
import requests
filename = "/path/to/foo.wav"
read_json = ""
 
def read_file(filename, chunk_size=5242880):
    with open(filename, 'rb') as _file:
        while True:
            data = _file.read(chunk_size)
            if not data:
                break
            yield data
 
    headers = {'authorization': "c49b114cfe8e4b0b9ce7c31e216f914f"}
    response = requests.post('https://api.assemblyai.com/v2/upload',
                    headers=headers,
                    data=read_file(filename))
    read_json = response.json()

def submit_file():
    endpoint = "https://api.assemblyai.com/v2/transcript"

    json = {
       read_json
    }

    headers = {
        "authorization": "c49b114cfe8e4b0b9ce7c31e216f914f",
        "content-type": "application/json"
    }

    response = requests.post(endpoint, json=json, headers=headers)