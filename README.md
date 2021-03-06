# ZooManager
A demo project used for component and contract testing. Exposes a simple API to serve as a "Provider"

## GitHub Setup

<details>
    <summary>Fulfil this section if you do not own a GitHub account:</summary>
    <ol>
        <li>Go to https://github.com/</li>
        <li>Click the Sign-Up button</li>
        <li>Enter your email address, password and username</li>
        <li>Enter your verification code received on your email</li>
        <li>Create the account of your choice (most likely a free one ;) )</li>
        <li>You should not be inside your account. Congrats!</li>
    </ol>
</details>

<br>

<details>
    <summary>Do this section if you have not set an authentication token (needed for pushing in the repos later)</summary>
    <ol>
        <li>Log in your account</li>
        <li>Click on your profile image in the top right corner and select Settings</li>
        <li>Select Developer settings - the last option in the left menu</li>
        <li>Select Personal access tokens</li>
        <li>Select Generate new token</li>
        <li>Write some description in the Note field</li>
        <li>Check the repo checkbox</li>
        <li>Press generate token.</li>
        <li>You should now see a special token generated. You need to use it as a password when pushing information to a repo.</li>
        <details>
            <summary>If you do not want to type this for every push do the following steps:</summary>
            <li>Open a command line terminal</li>
            <li>Type git config --global --list</li>
            <li>See what value you have for the key "credential.helper"</li>
            <li>
                We suggest it should be manager-core. 
                If not we recommend executing git config --global credential.helper manager-core.
                This will ensure that after the first time you are asked to type your username and 
                authorization token it will be cached for future purposes.
            </li>
        </details>
    </ol>
</details>

## OpenAPI

The OpenAPI/Swagger file can be found in the base directory of the project.
<details>
<summary>OpenAPI file usage and update</summary>
If file content update is needed after some changes to the API, you can either run "mvnw.cmd clean verify" in a console 
or run the "verify" goal from IntelliJ: Maven -> ZooManager -> Lifecycle
</details>

Proposals for reading OpenApi files:
<details>
    <summary>Add swagger to your IntelliJ</summary>
    <ol>
        <li>This approach is a little harder to initially setup but it will save you time afterwards!</li>
        <li>Open your IntelliJ instance</li>
        <li>Open File>Settings>Plugins>Marketplace</li>
        <li>Search for Swagger plugin. Keep in mind it may already be installed (check in the Installed section too)</li>
        <li>Install it if it has not been</li>
        <li>Open the yml/json file with the Swagger content</li>
        <li>You will see a small IntelliJ icon around the top right corner</li>
        <li>Press it and you will be able to see the swagger definition</li>
    </ol>
</details>
<details>
    <summary>Use online Swagger reader</summary>
    <ol>
        <li>This is the easier but not so comfortable approach.</li>
        <li>You need to copy the content of the json/yml file representing the Swagger documentation</li>
        <li>Open https://editor.swagger.io/</li>
        <li>Delete everything from the left-side panel</li>
        <li>Paste the copied content</li>
        <li>The swagger will be visualized in the right panel</li>
    </ol>
</details>
