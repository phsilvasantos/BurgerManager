class View {
    constructor() {
        this.scene = document.createElement("div");
    }
    createButton(text) {
        let button = document.createElement("button");
        button.textContent = text;
        button.type = "button";
        return button;
    }
    createInput(type, id) {
        let input = document.createElement("input");
        input.type = type;
        if (id)
            input.id = id;
        return input;
    }
    createLabel(text, targetId) {
        let label = document.createElement("label");
        label.setAttribute("for", targetId);
        label.textContent = text;
        return label;
    }
    createOption(value, text) {
        let option = document.createElement("option");
        option.value = value;
        option.textContent = text;
        return option;
    }
    createSelect(id) {
        let select = document.createElement("select");
        select.id = id;
        return select;
    }
    log(error, message) {
        if (error)
            View.log.classList.add("error");
        else
            View.log.classList.remove("error");
        View.log.innerHTML = message;
    }
    open() {
        View.stage.innerHTML = "";
        View.stage.appendChild(this.scene);
    }
}
View.cpfPattern = "\\d{3}.\\d{3}.\\d{3}-\\d{2}";
View.formatException = "Formato incorreto.";
View.log = document.querySelector("#log");
View.stage = document.querySelector("#stage");
class PrimaryView extends View {
    constructor() {
        super();
        this.scene.appendChild(this.createLabel("CPF", "cpf_input"));
        this.scene.appendChild(document.createElement("br"));
        this.cpfInput = this.createInput("text", "cpf_input");
        this.cpfInput.pattern = "(" + View.cpfPattern + "|gerente)";
        this.scene.appendChild(this.cpfInput);
        this.signInButton = this.createButton("Entrar");
        this.scene.appendChild(this.signInButton);
        this.scene.appendChild(document.createElement("hr"));
        this.newClientButton = this.createButton("Novo cliente");
        this.scene.appendChild(this.newClientButton);
        this.newEmployeeButton = this.createButton("Novo funcionário");
        this.scene.appendChild(this.newEmployeeButton);
    }
    get cpf() {
        if (!this.cpfInput.checkValidity())
            throw View.formatException;
        return this.cpfInput.value;
    }
    bindNewClient(handler) {
        this.newClientButton.addEventListener("click", handler);
    }
    bindNewEmployee(handler) {
        this.newEmployeeButton.addEventListener("click", handler);
    }
    bindSignIn(handler) {
        this.signInButton.addEventListener("click", handler);
    }
}
class PersonView extends View {
    constructor() {
        super();
        this.scene.appendChild(this.createLabel("CPF", "cpf_input"));
        this.scene.appendChild(document.createElement("br"));
        this.cpfInput = this.createInput("text", "cpf_input");
        this.cpfInput.pattern = View.cpfPattern;
        this.scene.appendChild(this.cpfInput);
        this.scene.appendChild(document.createElement("br"));
        this.scene.appendChild(this.createLabel("Nome", "name_input"));
        this.scene.appendChild(document.createElement("br"));
        this.nameInput = this.createInput("text", "name_input");
        this.scene.appendChild(this.nameInput);
        this.scene.appendChild(document.createElement("br"));
        this.scene.appendChild(this.createLabel("E-mail", "email_input"));
        this.scene.appendChild(document.createElement("br"));
        this.emailInput = this.createInput("email", "email_input");
        this.scene.appendChild(this.emailInput);
    }
    get cpf() {
        if (!this.cpfInput.checkValidity())
            throw View.formatException;
        return this.cpfInput.value;
    }
    set cpf(cpf) {
        this.cpfInput.value = cpf;
    }
    get email() {
        if (!this.emailInput.checkValidity())
            throw View.formatException;
        return this.emailInput.value;
    }
    set email(email) {
        this.emailInput.value = email;
    }
    get name() {
        let name = this.nameInput.value;
        if (name === "")
            throw View.formatException;
        return name;
    }
    set name(name) {
        this.nameInput.value = name;
    }
    clear() {
        this.cpfInput.value = "";
        this.emailInput.value = "";
        this.nameInput.value = "";
    }
}
class NewClientView extends PersonView {
    constructor() {
        super();
        this.scene.appendChild(document.createElement("br"));
        this.scene.appendChild(this.createLabel("Endereço", "street_input"));
        this.scene.appendChild(document.createElement("br"));
        this.streetInput = this.createInput("text", "street_input");
        this.streetInput.placeholder = "Rua";
        this.scene.appendChild(this.streetInput);
        this.numberInput = this.createInput("number");
        this.numberInput.placeholder = "Número";
        this.scene.appendChild(this.numberInput);
        this.districtInput = this.createInput("text");
        this.districtInput.placeholder = "Bairro";
        this.scene.appendChild(this.districtInput);
        this.scene.appendChild(document.createElement("hr"));
        this.okButton = this.createButton("OK");
        this.scene.appendChild(this.okButton);
        this.cancelButton = this.createButton("Cancelar");
        this.scene.appendChild(this.cancelButton);
    }
    get district() {
        let district = this.districtInput.value;
        if (district === "")
            throw View.formatException;
        return district;
    }
    set district(district) {
        this.districtInput.value = district;
    }
    get number() {
        if (!this.numberInput.checkValidity())
            throw View.formatException;
        return parseInt(this.numberInput.value);
    }
    set number(number) {
        this.numberInput.value = number.toString();
    }
    get street() {
        let street = this.streetInput.value;
        if (street === "")
            throw View.formatException;
        return street;
    }
    set street(street) {
        this.streetInput.value = street;
    }
    bindCancel(handler) {
        this.cancelButton.addEventListener("click", handler);
    }
    bindOk(handler) {
        this.okButton.addEventListener("click", handler);
    }
    clear() {
        super.clear();
        this.districtInput.value = "";
        this.numberInput.value = "";
        this.streetInput.value = "";
    }
}
class Person {
    constructor(cpf) {
        this.cpf = cpf;
    }
    toString() {
        let p = "cpf: " + this.cpf;
        p += "\nnome: " + this.name;
        p += "\ne-mail: " + this.email;
        return p;
    }
}
class Address {
    constructor(number, street, district) {
        this.district = district;
        this.number = number;
        this.street = street;
    }
}
class Client extends Person {
    constructor(cpf, address) {
        super(cpf);
        this.address = address;
    }
    get actions() {
        return Client.actions;
    }
    get type() {
        return Client.type;
    }
    toString() {
        return super.toString() + "\nEndereço: " + this.address;
    }
}
Client.actions = [];
Client.type = "Cliente";
class Employee extends Person {
    constructor(cpf) {
        super(cpf);
        this.profile = new Map();
    }
    toString() {
        let e = super.toString();
        for (let attribute in this.profile)
            e += "\n" + attribute + ": " + this.profile[attribute];
        e += "\nfunção: " + this.type.toLowerCase();
        return e;
    }
}
class Manager extends Employee {
    constructor() {
        super("000.000.000-00");
    }
    get actions() {
        return Manager.actions;
    }
    get type() {
        return Manager.type;
    }
}
Manager.actions = [];
Manager.type = "Gerente";
class Model {
    constructor() {
        this._candidates = [];
        this.clients = new Map();
        this.employees = new Map();
        this._manager = new Manager();
        this._manager.name = "Batata";
        this._manager.email = "batata@burgerman";
    }
    get candidates() {
        return this._candidates.slice(0);
    }
    set candidate(candidate) {
        this._candidates.push(candidate);
    }
    set client(client) {
        this.clients.set(client.cpf, client);
    }
    set employee(employee) {
        if (this.employees[employee.cpf])
            throw Model.existingException;
        this.employees[employee.cpf] = employee;
    }
    get manager() {
        return this._manager;
    }
    clearCandidates() {
        this._candidates = [];
    }
    getCandidate(index) {
        let candidate = this._candidates[index];
        if (!candidate)
            throw Model.notFoundException;
        return candidate;
    }
    getPerson(cpf) {
        let person = this.employees.get(cpf);
        if (!person) {
            person = this.clients.get(cpf);
            if (!person)
                throw Model.notFoundException;
        }
        return person;
    }
    removeCandidate(index) {
        this._candidates.splice(index, 1);
    }
}
Model.existingException = "Funcionário já existente.";
Model.notFoundException = "Não encontrado.";
class Controller {
    constructor(view, parent) {
        this.model = Controller.model;
        this.view = view;
        if (parent)
            this.parent = parent;
    }
    openView(message) {
        this.view.open();
        if (message)
            this.view.log(false, message);
        else
            this.view.log(false, "-");
    }
}
Controller.model = new Model();
class NewClientController extends Controller {
    constructor(parent) {
        super(new NewClientView(), parent);
        let view = this.view;
        view.bindCancel(this.handleCancel.bind(this));
        view.bindOk(this.handleOk.bind(this));
    }
    handleCancel(_event) {
        this.parent.openView("Adição cancelada.");
    }
    handleOk(_event) {
        try {
            let view = this.view;
            let address = new Address(view.number, view.street, view.district);
            let client = new Client(view.cpf, address);
            client.email = view.email;
            client.name = view.name;
            this.model.client = client;
            this.parent.openView("Cliente " + client.name + " adicionado.");
        }
        catch (ex) {
            this.view.log(true, ex);
        }
    }
    openView(message) {
        let view = this.view;
        view.clear();
        super.openView(message);
    }
}
class Boxer extends Employee {
    get actions() {
        return Boxer.actions;
    }
    get type() {
        return Boxer.type;
    }
}
Boxer.actions = [];
Boxer.type = "Embalador";
class Cook extends Employee {
    get actions() {
        return Cook.actions;
    }
    get type() {
        return Cook.type;
    }
}
Cook.actions = [];
Cook.type = "Cozinheiro";
class Deliverer extends Employee {
    get actions() {
        return Deliverer.actions;
    }
    get type() {
        return Deliverer.type;
    }
}
Deliverer.actions = [];
Deliverer.type = "Entregador";
class Supplier extends Employee {
    get actions() {
        return Supplier.actions;
    }
    get type() {
        return Supplier.type;
    }
}
Supplier.actions = [];
Supplier.type = "Fornecedor";
class NewEmployeeView extends PersonView {
    constructor() {
        super();
        this.scene.appendChild(document.createElement("br"));
        this.scene.appendChild(this.createLabel("Função", "type_select"));
        this.scene.appendChild(document.createElement("br"));
        this.typeSelect = this.createSelect("type_select");
        this.scene.appendChild(this.typeSelect);
        this.scene.appendChild(document.createElement("hr"));
        this.okButton = this.createButton("OK");
        this.scene.appendChild(this.okButton);
        this.cancelButton = this.createButton("Cancelar");
        this.scene.appendChild(this.cancelButton);
    }
    get type() {
        return this.typeSelect.value;
    }
    set types(types) {
        this.typeSelect.innerHTML = "";
        for (let [type, tag] of types)
            this.typeSelect.appendChild(this.createOption(type, tag));
    }
    bindCancel(handler) {
        this.cancelButton.addEventListener("click", handler);
    }
    bindOk(handler) {
        this.okButton.addEventListener("click", handler);
    }
}
class BoxerFactory {
    get tag() {
        return Boxer.type;
    }
    create(cpf) {
        return new Boxer(cpf);
    }
}
class CookFactory {
    get tag() {
        return Cook.type;
    }
    create(cpf) {
        return new Cook(cpf);
    }
}
class DelivererFactory {
    get tag() {
        return Deliverer.type;
    }
    create(cpf) {
        return new Deliverer(cpf);
    }
}
class SupplierFactory {
    get tag() {
        return Supplier.type;
    }
    create(cpf) {
        return new Supplier(cpf);
    }
}
class NewEmployeeController extends Controller {
    constructor(parent) {
        super(new NewEmployeeView(), parent);
        this.factories = new Map();
        this.factories.set("boxer", new BoxerFactory());
        this.factories.set("cook", new CookFactory());
        this.factories.set("deliverer", new DelivererFactory());
        this.factories.set("supplier", new SupplierFactory());
        let view = this.view;
        view.bindCancel(this.handleCancel.bind(this));
        view.bindOk(this.handleOk.bind(this));
    }
    handleCancel(_event) {
        this.parent.openView("Adição cancelada.");
    }
    handleOk(_event) {
        try {
            let view = this.view;
            let employee = this.factories.get(view.type).create(view.cpf);
            employee.email = view.email;
            employee.name = view.name;
            this.model.candidate = employee;
            this.parent.openView("Adição de funcionário " + employee.name + " aguardando aprovação.");
        }
        catch (ex) {
            this.view.log(true, ex);
        }
    }
    openView(message) {
        let view = this.view;
        view.clear();
        let types = new Map();
        for (let [type, factory] of this.factories)
            types.set(type, factory.tag);
        view.types = types;
        super.openView(message);
    }
}
class SignInView extends View {
    constructor() {
        super();
        this.scene.appendChild(this.createLabel("Ação", "action_select"));
        this.scene.appendChild(document.createElement("br"));
        this.actionSelect = this.createSelect("action_select");
        this.scene.appendChild(this.actionSelect);
        this.executeButton = this.createButton("Executar");
        this.scene.appendChild(this.executeButton);
        this.scene.appendChild(document.createElement("hr"));
        this.signOutButton = this.createButton("Sair");
        this.scene.appendChild(this.signOutButton);
    }
    get action() {
        return this.actionSelect.value;
    }
    set actions(actions) {
        this.actionSelect.innerHTML = "";
        for (let [action, tag] of actions)
            this.actionSelect.appendChild(this.createOption(action, tag));
    }
    bindExecute(handler) {
        this.executeButton.addEventListener("click", handler);
    }
    bindSignOut(handler) {
        this.signOutButton.addEventListener("click", handler);
    }
}
class EmployeeView extends PersonView {
    constructor() {
        super();
        this.cpfInput.readOnly = true;
        this.scene.appendChild(document.createElement("br"));
        this.scene.appendChild(this.createLabel("Função", "type_input"));
        this.scene.appendChild(document.createElement("br"));
        this.typeInput = this.createInput("text", "type_input");
        this.typeInput.readOnly = true;
        this.scene.appendChild(this.typeInput);
    }
    get type() {
        return this.typeInput.value;
    }
    set type(type) {
        this.typeInput.value = type;
    }
    clear() {
        super.clear();
        this.typeInput.value = "";
    }
}
class AddEmployeesView extends EmployeeView {
    constructor() {
        super();
        this.emailInput.readOnly = true;
        this.nameInput.readOnly = true;
        let child = this.scene.firstChild;
        this.scene.insertBefore(this.createLabel("Candidato", "employee_select"), child);
        this.scene.insertBefore(document.createElement("br"), child);
        this.candidateSelect = this.createSelect("employee_select");
        this.scene.insertBefore(this.candidateSelect, child);
        this.addButton = this.createButton("Adicionar");
        this.scene.insertBefore(this.addButton, child);
        this.scene.insertBefore(document.createElement("hr"), child);
        this.scene.appendChild(document.createElement("hr"));
        this.closeButton = this.createButton("Fechar");
        this.scene.appendChild(this.closeButton);
    }
    get candidateIndex() {
        return this.candidateSelect.selectedIndex;
    }
    set candidates(candidates) {
        this.candidateSelect.innerHTML = "";
        for (let index = 0; index < candidates.length; index++)
            this.candidateSelect.appendChild(this.createOption(index.toString(), candidates[index]));
    }
    bindAdd(handler) {
        this.addButton.addEventListener("click", handler);
    }
    bindClose(handler) {
        this.closeButton.addEventListener("click", handler);
    }
    bindSelect(handler) {
        this.candidateSelect.addEventListener("change", handler);
    }
}
class AddEmployeesController extends Controller {
    constructor(parent) {
        super(new AddEmployeesView(), parent);
        let view = this.view;
        view.bindAdd(this.handleAdd.bind(this));
        view.bindClose(this.handleClose.bind(this));
        view.bindSelect(this.handleSelect.bind(this));
    }
    handleAdd(_event) {
        try {
            let view = this.view;
            let index = view.candidateIndex;
            let employee = this.model.getCandidate(index);
            this.model.employee = employee;
            this.model.removeCandidate(index);
            view.candidates = this.model.candidates.map((candidate) => { return candidate.name; });
            this.handleSelect(null);
            view.log(false, "Funcionário " + employee.name + " adicionado.");
        }
        catch (ex) {
            this.view.log(true, ex);
        }
    }
    handleClose(_event) {
        this.model.clearCandidates();
        this.parent.openView();
    }
    handleSelect(_event) {
        let view = this.view;
        view.clear();
        let employee = this.model.getCandidate(view.candidateIndex);
        view.cpf = employee.cpf;
        view.email = employee.email;
        view.name = employee.name;
        view.type = employee.type;
    }
    openView(message) {
        let view = this.view;
        view.candidates = this.model.candidates.map((candidate) => { return candidate.name; });
        this.handleSelect(null);
        super.openView(message);
    }
}
class EditClientView extends NewClientView {
    constructor() {
        super();
        this.cpfInput.readOnly = true;
    }
}
class EditClientController extends Controller {
    constructor(parent) {
        super(new EditClientView(), parent);
        let view = this.view;
        view.bindCancel(this.handleCancel.bind(this));
        view.bindOk(this.handleOk.bind(this));
    }
    set client(client) {
        this._client = client;
    }
    handleCancel(_event) {
        this.parent.openView("Alteração cancelada.");
    }
    handleOk(_event) {
        try {
            let view = this.view;
            this._client.address.district = view.district;
            this._client.address.number = view.number;
            this._client.address.street = view.street;
            this._client.email = view.email;
            this._client.name = view.name;
            this.parent.openView("Perfil de " + this._client.name + " alterado.");
        }
        catch (ex) { }
    }
    openView(message) {
        let view = this.view;
        view.cpf = this._client.cpf;
        view.district = this._client.address.district;
        view.email = this._client.email;
        view.name = this._client.name;
        view.number = this._client.address.number;
        view.street = this._client.address.street;
        super.openView(message);
    }
}
class EditEmployeeView extends EmployeeView {
    constructor() {
        super();
        this._profile = new Map();
        this.scene.appendChild(document.createElement("hr"));
        this.scene.appendChild(this.createLabel("Perfil", "attribute_input"));
        this.profileField = document.createElement("p");
        this.scene.appendChild(this.profileField);
        this.attributeInput = this.createInput("text", "attribute_input");
        this.attributeInput.placeholder = "Atributo";
        this.scene.appendChild(this.attributeInput);
        this.valueInput = this.createInput("text");
        this.valueInput.placeholder = "Valor";
        this.scene.appendChild(this.valueInput);
        this.addButton = this.createButton("+");
        this.addButton.addEventListener("click", this.handleAdd.bind(this));
        this.scene.appendChild(this.addButton);
        this.scene.appendChild(document.createElement("hr"));
        this.okButton = this.createButton("OK");
        this.scene.appendChild(this.okButton);
        this.cancelButton = this.createButton("Cancelar");
        this.scene.appendChild(this.cancelButton);
    }
    handleAdd(_event) {
        let attribute = this.attributeInput.value.toLowerCase();
        if (attribute === "cpf") {
            this.log(true, "Atributo inválido.");
            return;
        }
        let value = this.valueInput.value;
        if (attribute === "email" || attribute === "e-mail")
            this.emailInput.value = value;
        else if (attribute === "nome")
            this.nameInput.value = value;
        else {
            this._profile.set(attribute, value);
            this.displayProfile();
        }
    }
    get profile() {
        return new Map(this._profile);
    }
    set profile(profile) {
        this._profile.clear();
        for (let [attribute, value] of profile)
            this.profile.set(attribute, value);
        this.displayProfile();
    }
    bindCancel(handler) {
        this.cancelButton.addEventListener("click", handler);
    }
    bindOk(handler) {
        this.okButton.addEventListener("click", handler);
    }
    clear() {
        super.clear();
        this.attributeInput.value = "";
        this.valueInput.value = "";
    }
    displayProfile() {
        this.profileField.innerHTML = "";
        for (let attribute in this.profile) {
            if (this.profileField.firstChild)
                this.profileField.appendChild(document.createElement("br"));
            this.profileField.appendChild(document.createTextNode(attribute + ": " + this.profile[attribute]));
        }
    }
}
class EditEmployeeController extends Controller {
    constructor(parent) {
        super(new EditEmployeeView(), parent);
        let view = this.view;
        view.bindCancel(this.handleCancel.bind(this));
        view.bindOk(this.handleOk.bind(this));
    }
    set employee(employee) {
        this._employee = employee;
    }
    handleCancel(_event) {
        this.parent.openView("Alteração cancelada.");
    }
    handleOk(_event) {
        let view = this.view;
        this._employee.email = view.name;
        this._employee.name = view.name;
        this._employee.profile = view.profile;
        this.parent.openView("Perfil de " + this._employee.name + " alterado.");
    }
    openView(message) {
        let view = this.view;
        view.clear();
        view.cpf = this._employee.cpf;
        view.email = this._employee.email;
        view.name = this._employee.name;
        view.profile = this._employee.profile;
        view.type = this._employee.type;
        super.openView(message);
    }
}
class Command {
    constructor(controller) {
        this.controller = controller;
    }
    execute(_agent) {
        this.controller.openView();
    }
}
class AddEmployees extends Command {
    constructor(parent) {
        super(new AddEmployeesController(parent));
    }
    get tag() {
        return "Adicionar funcionários";
    }
}
class EditClient extends Command {
    constructor(parent) {
        super(new EditClientController(parent));
    }
    get tag() {
        return "Editar perfil";
    }
    execute(agent) {
        let controller = this.controller;
        controller.client = agent;
        super.execute(null);
    }
}
class EditEmployee extends Command {
    constructor(parent) {
        super(new EditEmployeeController(parent));
    }
    get tag() {
        return "Editar perfil";
    }
    execute(agent) {
        let controller = this.controller;
        controller.employee = agent;
        super.execute(null);
    }
}
class SignInController extends Controller {
    constructor(parent) {
        super(new SignInView(), parent);
        this.actions = new Map();
        this.actions.set("addEmployees", new AddEmployees(this));
        this.actions.set("editClient", new EditClient(this));
        this.actions.set("editEmployee", new EditEmployee(this));
        Boxer.actions.push("editEmployee");
        Client.actions.push("editClient");
        Cook.actions.push("editEmployee");
        Deliverer.actions.push("editEmployee");
        Manager.actions.push("addEmployees", "editEmployee");
        Supplier.actions.push("editEmployee");
        let view = this.view;
        view.bindExecute(this.handleExecute.bind(this));
        view.bindSignOut(this.handleSignOut.bind(this));
    }
    set person(person) {
        this._person = person;
    }
    handleExecute(_event) {
        let view = this.view;
        this.actions.get(view.action).execute(this._person);
    }
    handleSignOut(_event) {
        this.parent.openView("Até a próxima.");
    }
    openView(message) {
        let actions = new Map();
        for (let action of this._person.actions)
            actions.set(action, this.actions.get(action).tag);
        let view = this.view;
        view.actions = actions;
        super.openView(message);
    }
}
class PrimaryController extends Controller {
    constructor() {
        super(new PrimaryView());
        this.newClientController = new NewClientController(this);
        this.newEmployeeController = new NewEmployeeController(this);
        this.signInController = new SignInController(this);
        let view = this.view;
        view.bindNewClient(this.handleNewClient.bind(this));
        view.bindNewEmployee(this.handleNewEmployee.bind(this));
        view.bindSignIn(this.handleSignIn.bind(this));
    }
    handleNewClient(_event) {
        this.newClientController.openView();
    }
    handleNewEmployee(_event) {
        this.newEmployeeController.openView();
    }
    handleSignIn(_event) {
        try {
            let view = this.view;
            let cpf = view.cpf;
            let person;
            if (cpf === "gerente")
                person = this.model.manager;
            else
                person = this.model.getPerson(cpf);
            this.signInController.person = person;
            this.signInController.openView("Bem-vindo, " + person.name + ".");
        }
        catch (ex) {
            this.view.log(true, ex);
        }
    }
}
let burgerMan = new PrimaryController();
burgerMan.openView();
