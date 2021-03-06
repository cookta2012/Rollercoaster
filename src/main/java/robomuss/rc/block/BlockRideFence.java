package robomuss.rc.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import robomuss.rc.block.te.TileEntityRideFence;
import robomuss.rc.item.RCItems;
import robomuss.rc.util.IPaintable;

import java.util.Random;

public class BlockRideFence extends BlockContainer implements IPaintable {

	public BlockRideFence() {
		super(Material.iron);
		setHardness(1F);
		setResistance(3F);
		setBlockBounds(0, 0, 0, 1, 1, 1);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityRideFence();
	}
	
	@Override
	public boolean hasTileEntity(int metadata) {
		return true;
	}


	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(!world.isRemote) {
			if(player.getHeldItem() != null) {
				if(player.getHeldItem().getItem() == RCItems.brush) {
					TileEntityRideFence terf = (TileEntityRideFence) world.getTileEntity(x, y, z);
					terf.colour = player.getHeldItem().getItemDamage();
					world.markBlockForUpdate(x, y, z);
					return true;
				}
				else {
					return false;
				}
				
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public int getPaintMeta(World world, int x, int y, int z) {
		return ((TileEntityRideFence) world.getTileEntity(x, y, z)).colour;
	}
	
	@Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if(!world.isRemote) {
        	if(this == RCBlocks.ride_fence_gate) {
	        	TileEntityRideFence te = (TileEntityRideFence) world.getTileEntity(x, y, z);
	        	te.open = world.isBlockIndirectlyGettingPowered(x, y, z);
	        	world.markBlockForUpdate(x, y, z);
        	}
        }
    }
	
	@Override
	public Item getItemDropped(int i, Random random, int j) {
		return super.getItemDropped(i, random, j);
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess iba, int x, int y, int z) {
		TileEntity te = iba.getTileEntity(x, y, z);
		if(te.getBlockType() == RCBlocks.ride_fence_gate) {
			TileEntityRideFence terf = (TileEntityRideFence) te;
			if(terf.open) {
				setBlockBounds(0, 0, 0, 0, 0, 0);
			}
			else {
				setBlockBounds(0, 0, 0, 1, 1, 1);
			}
		}
		else {
			setBlockBounds(0, 0, 0, 1, 1, 1);
		}
	}
}
