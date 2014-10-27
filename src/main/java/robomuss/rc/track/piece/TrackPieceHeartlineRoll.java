package robomuss.rc.track.piece;

import net.minecraft.client.model.ModelBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.client.model.IModelCustom;

import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

import robomuss.rc.block.BlockTrackBase;
//import robomuss.rc.block.te.TileEntityTrack;
import robomuss.rc.block.te.TileEntityTrackBase;
import robomuss.rc.track.TrackManager;
import robomuss.rc.track.style.TrackStyle;
import robomuss.rc.util.IInventoryRenderSettings;

public class TrackPieceHeartlineRoll extends TrackPiece implements IInventoryRenderSettings {
	public static final String partName = "heartline_roll";

	public TrackPieceHeartlineRoll(String unlocalized_name, int crafting_cost, int special_render_stages) {
		super(unlocalized_name, crafting_cost, special_render_stages);
	}

	@Override
	public void renderSpecialTileEntity(int renderStage, TrackStyle style, TileEntityTrackBase teTrack, World world, int x, int y, int z) {
		rotate(teTrack, world, x, y, z);
		/*if(renderStage <= 9) {
			GL11.glRotatef(-3f * renderStage, 0, 1, 0);
		}
		else {
			GL11.glRotatef(3f * renderStage, 0, 1, 0);
		}*/
//		GL11.glRotatef(20f * renderStage, 1, 0, 0);
//		IModelCustom model = type.getStandardModel();
		IModelCustom model = style.getModel();
//		model.renderAll();
		GL11.glPushMatrix();
		if (true) {
			GL11.glTranslatef(0f, -8f, 0f);
		} else {
			GL11.glTranslatef(24f, -8f, 0f);
		}
//		GL11.glTranslatef(0f, -8f, 0f);
		GL11.glScalef(1f, 1f, 1f);
		GL11.glPushMatrix();
		GL11.glScalef(0.5f,0.5f, 0.5f);
		model.renderPart(partName);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	
	@Override
	public float getSpecialX(int renderStage, double x, TileEntityTrackBase teTrack, World world, int lx , int ly , int lz) {
//        TileEntityTrackBase tileEntityTrackBase = (TileEntityTrackBase) world.getTileEntity(lx, ly, lz);
//		if(teTrack.direction == ForgeDirection.WEST || teTrack.direction == ForgeDirection.EAST) {
//			return (float) (x + 0.5f + (renderStage * 0.5f));
//		} else {
//			return (float) (x + 0.5f);
//		}
		if (teTrack != null && teTrack.track != null) {
			int trackMeta = world.getBlockMetadata(teTrack.xCoord, teTrack.yCoord, teTrack.zCoord);
			if (trackMeta == 4 || trackMeta == 5) {
//				return (float) (x + 0.5f + (renderStage * 0.5f));
				return (float) (x + 0.5f);
			} else {
				return (float) (x + 0.5f);
			}
		} else {
			return (float) (x + 0.5f);
		}
	}

	@Override
	public float getSpecialY(int renderStage, double y, TileEntityTrackBase teTrack, World world, int lx, int ly, int lz) {
		return (float) (y + 0.5f);
	}
	
	@Override
	public float getSpecialZ(int renderStage, double z, TileEntityTrackBase teTrack, World world, int lx , int ly , int lz) {
//        TileEntityTrackBase tileEntityTrackBase = (TileEntityTrackBase) world.getTileEntity(lx, ly, lz);
//		if(teTrack.direction == ForgeDirection.SOUTH || teTrack.direction == ForgeDirection.NORTH) {
//			return (float) (z + 0.5f + (renderStage * 0.5f));
//		} else {
//			return (float) (z + 0.5f);
//		}
		if (teTrack != null && teTrack.track != null) {
			int trackMeta = world.getBlockMetadata(teTrack.xCoord, teTrack.yCoord, teTrack.zCoord);
			if (trackMeta == 2 || trackMeta == 3) {
//				return (float) (z + 0.5f + (renderStage * 0.5f));
				return (float) (z + 0.5f);
			} else {
				return (float) (z + 0.5f);
			}
		} else {
			return (float) (z + 0.5f);
		}
	}
	
	@Override
	public AxisAlignedBB getRenderBoundingBox(World world, int xCoord, int yCoord, int zCoord) {
		return AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 10, yCoord + 3, zCoord + 10);
	}


	@Override
	public float getInventoryX() {
		return 0;
	}


	@Override
	public float getInventoryY() {
		return 0;
	}


	@Override
	public float getInventoryZ() {
		return 0;
	}


	@Override
	public float getInventoryScale() {
		return 1f;
	}
	
	@Override
	public boolean useIcon() {
		return true;
	}


	@Override
	public float getInventoryRotation() {
		return 0;
	}
}
