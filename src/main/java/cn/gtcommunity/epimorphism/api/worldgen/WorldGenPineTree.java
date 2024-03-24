package cn.gtcommunity.epimorphism.api.worldgen;

import cn.gtcommunity.epimorphism.common.blocks.EPMetablocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import javax.annotation.Nonnull;
import java.util.Random;

public class WorldGenPineTree extends WorldGenAbstractTree {


    public static final WorldGenPineTree TREE_GROW_INSTANCE = new WorldGenPineTree();

    public WorldGenPineTree() {
        super(true);
    }

    @Override
    public boolean generate(@Nonnull World world, @Nonnull Random random, @Nonnull BlockPos pos) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        BlockPos pos1 = new BlockPos(x, y, z);

        while (world.isAirBlock(pos1) && y > 2) {
            --y;
        }

        Block aSoilBlock = world.getBlockState(pos1).getBlock();

        if (!canBlockSustainSapling(world, aSoilBlock, x, y, z)) {
            return false;
        } else {
            int height;
            int branches;
            for (height = -2; height <= 2; ++height) {
                for (branches = -2; branches <= 2; ++branches) {
                    if (world.isAirBlock(pos1.add(height, -1, branches))
                            && world.isAirBlock(pos1.add(height, -2, branches))
                            && !world.isAirBlock(pos1.add(height, 0, branches))) {
                        return false;
                    }
                }
            }

            height = 2 + randInt(8, 16);
            branches = 2 + randInt(6, 18);
            int h = 1;
            aSoilBlock.onPlantGrow(world.getBlockState(pos1.down()), world, pos1.down(), pos1);

            int c;
            int r = randInt(1, 3);
            for (c = 0; c < height; ++c) {
                this.buildBlock(world, x, y + h, z, EPMetablocks.EP_PINE_LOG, 2);
                h++;
                if (c >= r && c % 2 == 0) {
                    this.generateBranch(world, random, x, y + h, z, c);
                }
            }

            this.generateTop(world, x, y + h, z);
            return true;
        }
    }

    public static int randInt(final int min, final int max) {
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        return new Random().nextInt((max - min) + 1) + min;
    }

    public void generateTop(World world, int x, int y, int z) {
        for (int i = -1; i < 2; ++i) {
            for (int j = -1; j < 2; ++j) {
                this.buildBlock(world, x + i, y, z + j, EPMetablocks.EP_PINE_LOG, 2);
            }
        }

        this.buildBlock(world, x, y, z, EPMetablocks.EP_PINE_LOG, 2);
        this.buildBlock(world, x + 1, y + 1, z, EPMetablocks.EP_PINE_LEAVES, 0);
        this.buildBlock(world, x, y + 1, z - 1, EPMetablocks.EP_PINE_LEAVES, 0);
        this.buildBlock(world, x, y + 1, z + 1, EPMetablocks.EP_PINE_LEAVES, 0);
        this.buildBlock(world, x - 1, y + 1, z, EPMetablocks.EP_PINE_LEAVES, 0);
        this.buildBlock(world, x, y + 2, z, EPMetablocks.EP_PINE_LEAVES, 0);
    }

    public void generateBranch(World world, Random rand, int x, int y, int z, int n) {
        int var99999;
        int var99998;
        for (var99999 = -1; var99999 < 2; ++var99999) {
            for (var99998 = -1; var99998 < 2; ++var99998) {
                this.buildBlock(world, x + var99999, y, z + var99998, EPMetablocks.EP_PINE_LEAVES, 0);
            }
        }

        var99999 = rand.nextInt(2);
        var99998 = rand.nextInt(2);
        int var99997 = rand.nextInt(2);
        int var99996 = rand.nextInt(2);
        if (n % 2 == 0) {
            if (var99998 == 0) {
                this.buildBlock(world, x + 1, y - 1, z - 2, EPMetablocks.EP_PINE_LEAVES, 0);
                this.buildBlock(world, x + 2, y - 1, z - 1, EPMetablocks.EP_PINE_LEAVES, 0);
                if (var99999 == 0) {
                    this.buildBlock(world, x + 2, y - 2, z - 2, EPMetablocks.EP_PINE_LEAVES, 0);
                } else {
                    this.buildBlock(world, x + 2, y - 1, z - 2, EPMetablocks.EP_PINE_LEAVES, 0);
                }
            } else {
                this.buildBlock(world, x + 1, y, z - 2, EPMetablocks.EP_PINE_LEAVES, 0);
                this.buildBlock(world, x + 2, y, z - 1, EPMetablocks.EP_PINE_LEAVES, 0);
                this.buildBlock(world, x + 2, y, z - 2, EPMetablocks.EP_PINE_LEAVES, 0);
            }

            if (var99997 == 0) {
                this.buildBlock(world, x - 2, y - 1, z + 1, EPMetablocks.EP_PINE_LEAVES, 0);
                this.buildBlock(world, x - 1, y - 1, z + 2, EPMetablocks.EP_PINE_LEAVES, 0);
                if (var99996 == 0) {
                    this.buildBlock(world, x - 2, y - 2, z + 2, EPMetablocks.EP_PINE_LEAVES, 0);
                } else {
                    this.buildBlock(world, x - 2, y - 1, z + 2, EPMetablocks.EP_PINE_LEAVES, 0);
                }
            } else {
                this.buildBlock(world, x - 2, y, z + 1, EPMetablocks.EP_PINE_LEAVES, 0);
                this.buildBlock(world, x - 1, y, z + 2, EPMetablocks.EP_PINE_LEAVES, 0);
                this.buildBlock(world, x - 2, y, z + 2, EPMetablocks.EP_PINE_LEAVES, 0);
            }
        } else {
            if (var99998 == 0) {
                this.buildBlock(world, x + 2, y - 1, z + 1, EPMetablocks.EP_PINE_LEAVES, 0);
                this.buildBlock(world, x + 1, y - 1, z + 2, EPMetablocks.EP_PINE_LEAVES, 0);
                if (var99999 == 0) {
                    this.buildBlock(world, x + 2, y - 2, z + 2, EPMetablocks.EP_PINE_LEAVES, 0);
                } else {
                    this.buildBlock(world, x + 2, y - 1, z + 2, EPMetablocks.EP_PINE_LEAVES, 0);
                }
            } else {
                this.buildBlock(world, x + 2, y, z + 1, EPMetablocks.EP_PINE_LEAVES, 0);
                this.buildBlock(world, x + 1, y, z + 2, EPMetablocks.EP_PINE_LEAVES, 0);
                if (var99999 == 0) {
                    this.buildBlock(world, x + 2, y - 1, z + 2, EPMetablocks.EP_PINE_LEAVES, 0);
                } else {
                    this.buildBlock(world, x + 2, y, z + 2, EPMetablocks.EP_PINE_LEAVES, 0);
                }
            }

            if (var99997 == 0) {
                this.buildBlock(world, x - 1, y - 1, z - 2, EPMetablocks.EP_PINE_LEAVES, 0);
                this.buildBlock(world, x - 2, y - 1, z - 1, EPMetablocks.EP_PINE_LEAVES, 0);
                if (var99996 == 0) {
                    this.buildBlock(world, x - 2, y - 2, z - 2, EPMetablocks.EP_PINE_LEAVES, 0);
                } else {
                    this.buildBlock(world, x - 2, y - 1, z - 2, EPMetablocks.EP_PINE_LEAVES, 0);
                }
            } else {
                this.buildBlock(world, x - 1, y, z - 2, EPMetablocks.EP_PINE_LEAVES, 0);
                this.buildBlock(world, x - 2, y, z - 1, EPMetablocks.EP_PINE_LEAVES, 0);
                if (var99996 == 0) {
                    this.buildBlock(world, x - 2, y - 1, z - 2, EPMetablocks.EP_PINE_LEAVES, 0);
                } else {
                    this.buildBlock(world, x - 2, y, z - 2, EPMetablocks.EP_PINE_LEAVES, 0);
                }
            }
        }

        this.buildBlock(world, x, y, z, EPMetablocks.EP_PINE_LOG, 2);
        this.buildBlock(world, x, y + 1, z, EPMetablocks.EP_PINE_LOG, 2);
    }

    public void buildBlock(World world, int x, int y, int z, Block block, int meta) {
        if (world.isAirBlock(new BlockPos(x, y, z)) || world.getBlockState(new BlockPos(x, y, z)).getBlock().isLeaves(world.getBlockState(new BlockPos(x, y, z)), world, new BlockPos(x, y, z))) {
            world.setBlockState(new BlockPos(x, y, z), block.getStateFromMeta(meta), 2);
        }
    }

    public boolean canBlockSustainSapling(World world, Block block, int x, int y, int z) {
        return block.canSustainPlant(world.getBlockState(new BlockPos(x, y, z).down()), world, new BlockPos(x, y, z), EnumFacing.UP, (BlockSapling) Blocks.SAPLING);
    }
}