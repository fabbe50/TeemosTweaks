package com.fabbe50.ttweaks.stacksizes;

import com.fabbe50.ttweaks.LogHelper;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by fabbe on 09/07/2017.
 */
public class StackSizes {
    public static void init() {
        if (!Loader.isModLoaded("quark")) {
            Items.MINECART.setMaxStackSize(16);
            Items.CHEST_MINECART.setMaxStackSize(16);
            Items.FURNACE_MINECART.setMaxStackSize(16);
            Items.HOPPER_MINECART.setMaxStackSize(16);
            Items.TNT_MINECART.setMaxStackSize(16);
            Items.COMMAND_BLOCK_MINECART.setMaxStackSize(16);
        } else {LogHelper.info("Found 'Quark', disabling similar features.");}

        Items.BOAT.setMaxStackSize(16);
        Items.BIRCH_BOAT.setMaxStackSize(16);
        Items.ACACIA_BOAT.setMaxStackSize(16);
        Items.DARK_OAK_BOAT.setMaxStackSize(16);
        Items.JUNGLE_BOAT.setMaxStackSize(16);
        Items.SPRUCE_BOAT.setMaxStackSize(16);
        Items.SADDLE.setMaxStackSize(16);
        Items.ENDER_PEARL.setMaxStackSize(64);
        Items.SNOWBALL.setMaxStackSize(64);
        Items.EGG.setMaxStackSize(64);
        Items.ENCHANTED_BOOK.setMaxStackSize(16);
        Items.TOTEM_OF_UNDYING.setMaxStackSize(16);
        Items.CAKE.setMaxStackSize(16);

        //Items.POTIONITEM.setMaxStackSize(16);
        //Items.SPLASH_POTION.setMaxStackSize(16);
        //Items.LINGERING_POTION.setMaxStackSize(16);
        //Items.BEETROOT_SOUP.setMaxStackSize(16);
        //Items.MUSHROOM_STEW.setMaxStackSize(16);
        //Items.RABBIT_STEW.setMaxStackSize(16);

        Items.BUCKET.setMaxStackSize(64);
        Items.WATER_BUCKET.setMaxStackSize(16);
        Items.LAVA_BUCKET.setMaxStackSize(16);

        //Items.MILK_BUCKET.setMaxStackSize(16);

        //Tooltips
        //items.add(Items.BREWING_STAND);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.HIGH)
    public void applyTooltips(ItemTooltipEvent event) {
        if (event.getItemStack().getItem() == Items.MILK_BUCKET && false) {
            event.getToolTip().add("Who even drinks a cubic meter of milk?");
            event.getToolTip().add("Pour it into bottles first!");
        }
    }

    @SubscribeEvent
    public void onRightClick(PlayerInteractEvent.RightClickItem event) {
        if (!event.getWorld().isRemote) {
            if (event.getItemStack().getItem() == Items.WATER_BUCKET) {
                event.setCanceled(true);
            }
            else if (event.getItemStack().getItem() == Items.LAVA_BUCKET) {
                event.setCanceled(true);
            }
            else if (event.getItemStack().getItem() == Items.MILK_BUCKET) {
                //event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public void rightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        if (!event.getWorld().isRemote) {
            if (event.getWorld().getTileEntity(event.getPos()) != null) {

            }
            else if (event.getItemStack().getItem() == Items.WATER_BUCKET) {
                EnumFacing facing = event.getFace();

                try {
                    if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof BlockTallGrass && false)
                        event.getWorld().setBlockState(event.getPos(), Blocks.FLOWING_WATER.getDefaultState(), 11);
                    else
                        event.getWorld().setBlockState(event.getPos().offset(facing), Blocks.FLOWING_WATER.getDefaultState(), 11);
                } catch (Exception e) {
                    LogHelper.error("Failed to place liquid: " + e);
                    facing = EnumFacing.UP;
                    event.getWorld().setBlockState(event.getPos().offset(facing), Blocks.FLOWING_WATER.getDefaultState(), 11);
                }

                if (!event.getEntityPlayer().isCreative()) {
                    boolean notFull = event.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.BUCKET, 1, 0));
                    if (!notFull)
                        event.getEntityPlayer().dropItem(Items.BUCKET, 1);


                    if (event.getItemStack().getCount() > 1) {
                        event.getItemStack().shrink(1);
                    } else if (event.getItemStack().getCount() == 1) {
                        event.getItemStack().setCount(0);
                    }
                }
            } else if (event.getItemStack().getItem() == Items.LAVA_BUCKET) {
                EnumFacing facing = event.getFace();

                try {
                    if (event.getWorld().getBlockState(event.getPos()).getBlock() instanceof BlockTallGrass)
                        event.getWorld().setBlockState(event.getPos(), Blocks.FLOWING_LAVA.getDefaultState(), 11);
                    else
                        event.getWorld().setBlockState(event.getPos().offset(facing), Blocks.FLOWING_LAVA.getDefaultState(), 11);
                } catch (Exception e) {
                    LogHelper.error("Failed to place liquid: " + e);
                    facing = EnumFacing.UP;
                    event.getWorld().setBlockState(event.getPos().offset(facing), Blocks.FLOWING_LAVA.getDefaultState(), 11);
                }

                if (!event.getEntityPlayer().isCreative()) {
                    boolean notFull = event.getEntityPlayer().inventory.addItemStackToInventory(new ItemStack(Items.BUCKET, 1, 0));
                    if (!notFull)
                        event.getEntityPlayer().dropItem(Items.BUCKET, 1);


                    if (event.getItemStack().getCount() > 1) {
                        event.getItemStack().shrink(1);
                    } else if (event.getItemStack().getCount() == 1) {
                        event.getItemStack().setCount(0);
                    }
                }
            }
        }
    }
}
