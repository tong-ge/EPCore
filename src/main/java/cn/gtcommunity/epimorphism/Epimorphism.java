package cn.gtcommunity.epimorphism;

import cn.gtcommunity.epimorphism.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;

@Mod(
        modid = "epimorphism",
        name = "Epimorphism",
        acceptedMinecraftVersions = "[1.12.2,1.13)",
        version = "0.0.1-beta"
)
public class Epimorphism {

    public static final String MODID = "epimorphism";
    public static final String NAME = "Epimorphism";
    public static final String VERSION = "0.0.1-beta";

    @SidedProxy(
            clientSide = "cn.gtcommunity.epimorphism.client.ClientProxy",
            serverSide = "cn.gtcommunity.epimorphism.common.CommonProxy"
    )
    public static CommonProxy proxy;

    public Epimorphism() {}



}
