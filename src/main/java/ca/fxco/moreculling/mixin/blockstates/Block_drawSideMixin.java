package ca.fxco.moreculling.mixin.blockstates;

import ca.fxco.moreculling.api.block.MoreBlockCulling;
import ca.fxco.moreculling.utils.CullingUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Block.class)
public class Block_drawSideMixin implements MoreBlockCulling {

    /**
     * @author Fx Morin
     * @reason Many mods use Block.shouldDrawSide() directly so its basically required that I overwrite it
     * If your mixin breaks due to this, please use the API if MoreCulling is present
     */
    @Overwrite
    public static boolean shouldDrawSide(BlockState state, BlockView world,
                                         BlockPos pos, Direction side, BlockPos otherPos) {
        return CullingUtils.shouldDrawSideCulling(state, world, pos, side, otherPos);
    }
}
