package control_work.template.kr1.first;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class DragAndDropAdapter implements DropTargetListener {
    private final Panel<?> panel;

    public DragAndDropAdapter(Panel<?> panel) {
        this.panel = panel;
    }

    @Override
    public void dragEnter(DropTargetDragEvent dtde) {

    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {

    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {

    }

    @Override
    public void dragExit(DropTargetEvent dte) {

    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
        dtde.acceptDrop(DnDConstants.ACTION_COPY);
        Transferable transferable = dtde.getTransferable();
        DataFlavor[] flavors = transferable.getTransferDataFlavors();
        if (flavors.length == 0)
            return;
        if (flavors[0].isFlavorJavaFileListType()) {
            List<File> files;
            try {
                files = (List<File>)transferable.getTransferData(flavors[0]);
            } catch (UnsupportedFlavorException | IOException e) {
                throw new RuntimeException(e);
            }
            if (!files.isEmpty()) {
                panel.readDataFrom(files.get(0));
            }
        }
    }
}
