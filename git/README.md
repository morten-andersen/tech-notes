### Git commands

#### git config

```bash
git config --global user.email "<email>"
git config --global user.name "<name>"

# change the default editor on Ubuntu
sudo update-alternatives --config editor
```

#### clear all local branches except master and current

`git branch | egrep -v "(master|\*)" | xargs git branch -D`

#### git stash

* git stash list: `git stash list`
* git stash show diff: `git stash show -p stash@{0}`
* git stash drop: `git stash drop stash@{0}`

#### git diff

* git diff unpushed changes: `git diff origin/<branch>`

#### undo last local commit

* *soft* - keeping local changes: `git reset --soft HEAD~1`
* *hard* - discard local changes: `git reset --hard HEAD~1`

#### revert a single commit

* `git revert <sha>`

#### git relocate remote

* `git remote set-url origin <remote url>`

#### updating from a cloned/forked repository

* [Updating Cloned/Forked Repository On Local Machine and GitHub!](https://avilpage.com/2014/11/git-updating-clonedforked-repository-on.html)

#### execute git in subfolder

* `git -C <folder> <command>`

#### helper function for working with multiple repositories in subfolders

Insert in `~/.bash_aliases`

```bash
# command for executing a git command in all git sub folders
# usage:
#   git-sub status           show git status
#   git-sub fetch origin     fetch origin information
#   git-sub branch           show branches (local)
#
# use -i as first argument for interactive mode

git-sub () {
  interactive=''
  if [ "$1" == "-i" ]
  then
    shift
    interactive='-p'
  fi
  if [ $# -eq 0 ]
  then
    echo "usage: git-sub <git commands>"
    echo "       use '-i' as first arugment for interactive mode"
    return 1
  fi

  find . -maxdepth 3 -name .git -type d | rev | cut -c 6- | rev | xargs $interactive -I {} sh -c "echo '\n\033[1;32m{}\033[0m' && git -C {} $@"
}
```

#### using [GitLab push options](https://docs.gitlab.com/ce/user/project/push_options.html) to create a MR from command line

**Note** this is limited by the fact that you can only `push` (and thereby only push client side options) when `git push` has work to do. If you have nothing to push you will get an 'Everything up-to-date' info message from `git push`.

**create a git alias**

* which is named `mwps-master` (*merge when pipeline succeeds*)
* that creates a merge request with target `master` that automatically merges
* set the upstream branch to the same name as the current local branch (indicated by `origin HEAD`)
* also pushes any tags - e.g. created by `npm version`

```bash
git config --global alias.mwps-master "push -o merge_request.create -o merge_request.target=master -o merge_request.merge_when_pipeline_succeeds --set-upstream origin HEAD --follow-tags"
```

**use the alias**

* `git mwps-master` - will push and create a MR on gitlab from the current branch

#### working with git-flow branching

##### releasing a new version

**conceptual description of the flow**

* merge `development` into `master`
* create a new version and tag on `master`
* merge `master` back into `development`

**detailed steps on GitLab**

1. via gitlab GUI create a MR from development into master
2. when merged
3. `git checkout master` - checkout master
4. `git checkout -b branch<new-version>` - create a new branch
5. `npm version <patch | minor | major>` - create the version
6. `git mwps-master` - push branch and version tag, creating the MR.
7. go to the MR on gitlab GUI and approve
8. when done and merged
9. via gitlab GUI create a MR from master back on development
