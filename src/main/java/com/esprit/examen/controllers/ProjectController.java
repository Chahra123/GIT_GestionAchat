package com.esprit.examen.controllers;

import com.esprit.examen.entities.*;
import com.esprit.examen.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")

@RequiredArgsConstructor
public class ProjectController {

    private final IFactureService factureService;
    private final ICategorieProduitService categorieProduitService;

    private final IFournisseurService fournisseurService;

    private final IOperateurService operateurService;
    private final IProduitService produitService;


    @GetMapping
    public List<Fournisseur> getFournisseurs() {
        return fournisseurService.retrieveAllFournisseurs();
    }

    @GetMapping("/{fournisseur-id}")
    public Fournisseur retrieveFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
        return fournisseurService.retrieveFournisseur(fournisseurId);
    }

    @PostMapping
    public Fournisseur addFournisseur(@RequestBody Fournisseur f) {
        Fournisseur fournisseur = fournisseurService.addFournisseur(f);
        return fournisseur;
    }

    @DeleteMapping("/{fournisseur-id}")
    public void removeFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
        fournisseurService.deleteFournisseur(fournisseurId);
    }

    @PutMapping
    public Fournisseur modifyFournisseur(@RequestBody Fournisseur fournisseur) {
        return fournisseurService.updateFournisseur(fournisseur);
    }




    @GetMapping
    public List<Operateur> getOperateurs() {
        return operateurService.retrieveAllOperateurs();
    }

    @GetMapping("/{operateur-id}")
    public Operateur retrieveOperateur(@PathVariable("operateur-id") Long operateurId) {
        return operateurService.retrieveOperateur(operateurId);
    }

    @PostMapping
    public Operateur addOperateur(@RequestBody Operateur op) {
        Operateur operateur = operateurService.addOperateur(op);
        return operateur;
    }


    @DeleteMapping("/{operateur-id}")
    public void removeOperateur(@PathVariable("operateur-id") Long operateurId) {
        operateurService.deleteOperateur(operateurId);
    }


    @PutMapping
    public Operateur modifyOperateur(@RequestBody Operateur operateur) {
        return operateurService.updateOperateur(operateur);
    }

    @PutMapping(value = "/assignSecteurActiviteToFournisseur/{idSecteurActivite}/{idFournisseur}")
    public void assignProduitToStock(@PathVariable("idSecteurActivite") Long idSecteurActivite, @PathVariable("idFournisseur") Long idFournisseur) {
        fournisseurService.assignSecteurActiviteToFournisseur(idSecteurActivite, idFournisseur);
    }

    @GetMapping
    public List<Facture> getFactures() {
        return factureService.retrieveAllFactures();
    }

    @GetMapping("/{facture-id}")

    public Facture retrieveFacture(@PathVariable("facture-id") Long factureId) {
        return factureService.retrieveFacture(factureId);
    }

    @PostMapping
    public Facture addFacture(@RequestBody Facture f) {
        Facture facture = factureService.addFacture(f);
        return facture;
    }

    /*
     * une facture peut être annulée si elle a été saisie par erreur. Pour ce
     * faire, il suffit de mettre le champs active à false
     */
    @PutMapping("/cancel/{facture-id}")
    public void cancelFacture(@PathVariable("facture-id") Long factureId) {
        factureService.cancelFacture(factureId);
    }

    @GetMapping("/byfournisseur/{fournisseur-id}")
    public List<Facture> getFactureByFournisseur(@PathVariable("fournisseur-id") Long fournisseurId) {
        return factureService.getFacturesByFournisseur(fournisseurId);
    }

    @PutMapping(value = "/assign-to-operateur/{idOperateur}/{idFacture}")
    public void assignOperateurToFacture(@PathVariable("idOperateur") Long idOperateur, @PathVariable("idFacture") Long idFacture) {
        factureService.assignOperateurToFacture(idOperateur, idFacture);
    }

    @GetMapping(value = "/pourcentage-recouvrement/{startDate}/{endDate}")
    public float pourcentageRecouvrement(
            @PathVariable(name = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @PathVariable(name = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {

        return factureService.pourcentageRecouvrement(startDate, endDate);

    }
    
    @GetMapping
    public List<CategorieProduit> getCategorieProduit() {
        List<CategorieProduit> list = categorieProduitService.retrieveAllCategorieProduits();
        return list;
    }

    @PostMapping
    public CategorieProduit addCategorieProduit(@RequestBody CategorieProduit cp) {
        CategorieProduit categorieProduit = categorieProduitService.addCategorieProduit(cp);
        return categorieProduit;
    }

    @GetMapping("/{categorieProduit-id}")
    public CategorieProduit retrieveCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
        return categorieProduitService.retrieveCategorieProduit(categorieProduitId);
    }

    @DeleteMapping("{categorieProduit-id}")
    public void removeCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
        categorieProduitService.deleteCategorieProduit(categorieProduitId);
    }

    @PutMapping
    public CategorieProduit modifyCategorieProduit(@RequestBody CategorieProduit categorieProduit) {
        return categorieProduitService.updateCategorieProduit(categorieProduit);
    }

    @GetMapping
    public List<Produit> getProduits() {
        return produitService.retrieveAllProduits();
    }

}
