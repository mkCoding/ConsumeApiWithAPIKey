
## Created Application that consumes api with required API Key call

What I learned:
- How to make an api call and pass required key in the header
- How to hide API key in gitignore before pushing to GitHub
- API endpoint with parameters should not be put in endpoint within the app
- Make sure to add your API key to your **local.properties** before modifying your **build.gradle** file

```
// local.properties (example)
API_KEY=XXXXXXXXXXXXXXXXXXXX)
```

### Important Learning Screenshots


<div align="center">
  <div style="display: inline-block; width: 49%; text-align: center;">
    <p><b>Add API key to Header for Endpoint</b></p>
    <img src="https://github.com/user-attachments/assets/a6b5adac-6174-42d5-8264-14524728e999" style="width: 100%; height: auto;">
  </div>

  <div style="display: inline-block; width: 49%; text-align: center;">
    <p><b>Add API declared in ApiDetails</b></p>
    <img alt="Api Details - BuildConfig - Key" src="https://github.com/user-attachments/assets/839972e9-a07b-40f7-b970-341d0b97f7ac" height: auto; />
  </div>
  
  
  <div style="display: inline-block; width: 49%; text-align: center;">
    <p><b>Add API key to BuildConfig</b></p>
    <img src="https://github.com/user-attachments/assets/820fad0d-955d-4d97-8e19-4ae347532819" style="width: 100%; height: auto;">
    <b>After this make sure to Sync and Build your project</b>
  </div>
</div>

### Proof returning data

https://github.com/user-attachments/assets/998f9bcd-3a48-4b42-8e20-52c575b30dac

