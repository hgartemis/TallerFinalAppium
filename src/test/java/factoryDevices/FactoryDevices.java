package factoryDevices;

public class FactoryDevices {

    public static final String ANDROID = "android";
    public static final String CLOUD = "cloud";

    public static IDevice make(String typeDevice) {

        IDevice device = null;

        switch (typeDevice) {

            case ANDROID:
                device = new Android();
                break;
            case CLOUD:
                device = new CloudAndroid();
                break;
            default:
                device = new Android();
                break;
        }

        return device;

    }

}
