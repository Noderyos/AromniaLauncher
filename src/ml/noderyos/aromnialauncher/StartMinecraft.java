package ml.noderyos.aromnialauncher;

import fr.theshark34.openlauncherlib.external.ExternalLaunchProfile;
import fr.theshark34.openlauncherlib.external.ExternalLauncher;
import fr.theshark34.openlauncherlib.minecraft.*;
import net.chris54721.openmcauthenticator.OpenMCAuthenticator;
import net.chris54721.openmcauthenticator.Profile;
import net.chris54721.openmcauthenticator.responses.AuthenticationResponse;

public class StartMinecraft {
    public StartMinecraft(String username, String password)throws Exception{
            AuthenticationResponse authResponse = OpenMCAuthenticator.authenticate(username, password);
            Profile p = authResponse.getSelectedProfile();
            GameInfos infos = new GameInfos("AromniaLauncher", new GameVersion("1.7.10", GameType.V1_7_10), null);
            AuthInfos authInfos = new AuthInfos(username, authResponse.getAccessToken(), p.getUUID().toString());
            ExternalLaunchProfile profile = MinecraftLauncher.createExternalProfile(infos, GameFolder.BASIC, authInfos);
            ExternalLauncher launcher = new ExternalLauncher(profile);
            launcher.launch();
    }
}
