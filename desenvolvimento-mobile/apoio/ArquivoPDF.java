package com.lgapontes.pdf4me_v1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

public class ArquivoPDF {

    private Context context;
    private ImageView pdfView;
    private Uri uri;
    private int totalPaginas;
    private int paginaAtual;

    private ArquivoPDF(Context context, ImageView pdfView, Uri uri) {
        this.context = context;
        this.pdfView = pdfView;
        this.uri = uri;
        this.totalPaginas = 0;
        this.paginaAtual = 0;
    }

    public static ArquivoPDF abrir(Context context, ImageView pdfView, Uri uri) {
        ArquivoPDF arquivo = new ArquivoPDF(context, pdfView, uri);
        arquivo.exibir();
        return arquivo;
    }

    public void paginaAnterior() {
        int pagina = paginaAtual - 1;
        if (pagina >=0) {
            paginaAtual = pagina;
            exibir();
        }
    }

    public void paginaPosterior() {
        int pagina = paginaAtual + 1;
        if (pagina < totalPaginas) {
            paginaAtual = pagina;
            exibir();
        }
    }

    private void exibir() {
        try {
            /* Obter PDF Renderer */
            ParcelFileDescriptor fileDescriptor = context.getContentResolver()
                    .openFileDescriptor(this.uri, "r");
            PdfRenderer pdfRenderer = new PdfRenderer(fileDescriptor);

            /* Obter o total de páginas */
            totalPaginas = pdfRenderer.getPageCount();

            /* Abrir na página específica */
            PdfRenderer.Page rendererPage = pdfRenderer.openPage(paginaAtual);
            int rendererPageWidth = rendererPage.getWidth();
            int rendererPageHeight = rendererPage.getHeight();
            Bitmap bitmap = Bitmap.createBitmap(
                    rendererPageWidth,
                    rendererPageHeight,
                    Bitmap.Config.ARGB_8888);
            rendererPage.render(bitmap, null, null,
                    PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
            pdfView.setImageBitmap(bitmap);

            /* Fechar referência ao PDF */
            rendererPage.close();
            pdfRenderer.close();
            fileDescriptor.close();
        } catch (Exception e) {
            Toast.makeText(context, "Erro ao abrir o arquivo!", Toast.LENGTH_LONG).show();
            Log.e("PDF4ME", e.getMessage());
        }
    }

}