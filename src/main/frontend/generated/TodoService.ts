import { EndpointRequestInit as EndpointRequestInit_1 } from "@vaadin/hilla-frontend";
import client_1 from "./connect-client.default.js";
import type Todo_1 from "./dev/kavindupere/aitodoplanner/data/Todo.js";
async function findAll_1(init?: EndpointRequestInit_1): Promise<Array<Todo_1>> { return client_1.call("TodoService", "findAll", {}, init); }
async function save_1(todo: Todo_1, init?: EndpointRequestInit_1): Promise<Todo_1> { return client_1.call("TodoService", "save", { todo }, init); }
export { findAll_1 as findAll, save_1 as save };
