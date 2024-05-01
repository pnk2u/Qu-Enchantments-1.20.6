package qu.quEnchantments.enchantments.weapon;


import qu.quEnchantments.QuEnchantments;
import qu.quEnchantments.enchantments.QuEnchantment;
import qu.quEnchantments.util.config.ModConfig;

public class AccuracyEnchantment extends QuEnchantment {

    private static final ModConfig.AccuracyOptions CONFIG = QuEnchantments.getConfig().accuracyOptions;

    public AccuracyEnchantment(Properties properties) {
        super(properties);
    }

//    @Override
//    public int getMaxLevel() {
//        return CONFIG.isEnabled ? 2 : 0;
//    }
//
//    @Override
//    public int getMinPower(int level) {
//        return 10 + 20 * (level - 1);
//    }
//
//    @Override
//    public int getMaxPower(int level) {
//        return getMinPower(level) + 50;
//    }

    @Override
    public boolean isAvailableForRandomSelection() {
        return CONFIG.randomSelection;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return CONFIG.bookOffer;
    }

    @Override
    public boolean isAvailableForEnchantingTable() {
        return CONFIG.enchantingTable;
    }
}
